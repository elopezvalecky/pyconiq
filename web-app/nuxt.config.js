const port = process.env.PORT || process.env.npm_package_config_nuxt_port || '3000'
const host = process.env.HOST || process.env.npm_package_config_nuxt_host || 'localhost'

module.exports = {
	srcDir : 'src/',
	env: {
	    baseUrl: process.env.BASE_URL || `http://${host}:${port}`
	},
	// Headers of the page
	head : {
		title : 'Payconiq | Web App',
		meta : [ {
			charset : 'utf-8'
		}, {
			name : 'viewport',
			content : 'width=device-width, initial-scale=1'
		}, {
			hid : 'description',
			name : 'description',
			content : 'Web App'
		} ],
		link : [ {
			rel : 'icon',
			type : 'image/x-icon',
			href : 'https://nuxtjs.org/favicon.ico'
		} ]
	},
	build : {
		postcss : {
			plugins : {
				'postcss-custom-properties' : false
			}
		}
	},
	modules : [ '@nuxtjs/font-awesome', '@nuxtjs/axios', '@nuxtjs/bulma' ]
}