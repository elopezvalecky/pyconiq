package com.payconiq.assignment;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class StockRestController {

	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StockRepository stockRepository;

	@RequestMapping(name="listStock", method=GET, produces="application/json")
	public Envelop<Stock> list(@RequestParam(required=false) Integer page, @RequestParam(required=false) Integer size) {
		if (page == null) page = 0; // Default value
		if (size == null) size = 10; // Default value

		// TODO: add support for sort

		final Page<Stock> result = stockRepository.findAll(new PageRequest(page, size));
		return new Envelop<>(result.getContent(), result.getTotalElements());
	}

	@RequestMapping(name="retriveStock", path="/{stockId}", method=GET, produces="application/json")
	public Stock get(@PathVariable long stockId) {
		return stockRepository.findOne(stockId);
	}

	@RequestMapping(name="modifyStock", path="/{stockId}", method=PUT, produces="application/json", consumes="application/json")
	@ResponseBody
	public ResponseEntity<Void> update(@PathVariable long stockId, @RequestBody Stock price) {
		Stock original = stockRepository.findOne(stockId);

		original.setCurrentPrice(price.getCurrentPrice());

		stockRepository.save(original);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(name="newStock", method=POST, produces="application/json", consumes="application/json")
	@ResponseBody
	public ResponseEntity<Void> create(@RequestBody Stock stock) {
		stockRepository.save(stock);

		Link self = linkTo(getClass()).slash(stock.getId()).withSelfRel();
		return ResponseEntity.created(URI.create(self.getHref())).build();
	}

	@RequestMapping(name="removeStock", path="/{stockId}", method=DELETE)
	@ResponseBody
	public ResponseEntity<Void> delete(@PathVariable long stockId) {
		stockRepository.delete(stockId);
		return ResponseEntity.noContent().build();
	}

}
