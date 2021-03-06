/* jshint node: true */

module.exports = function (environment) {
    var ENV = {
        modulePrefix: 'ember-app',
        environment: environment,
        baseURL: '/',
        API_HOST: '/',
        locationType: 'auto',
        EmberENV: {
            FEATURES: {
                // Here you can enable experimental features on an ember canary build
                // e.g. 'with-controller': true
            }
        },

        APP: {
            // Here you can pass flags/options to your application instance
            // when it is created
        }
    };

    if (environment === 'development') {
        ENV.API_HOST = 'http://localhost:8080';
        // ENV.APP.LOG_RESOLVER = true;
        // ENV.APP.LOG_ACTIVE_GENERATION = true;
        // ENV.APP.LOG_TRANSITIONS = true;
        // ENV.APP.LOG_TRANSITIONS_INTERNAL = true;
        // ENV.APP.LOG_VIEW_LOOKUPS = true;
    }

    if (environment === 'test') {
        // Testem prefers this...
        ENV.baseURL = '/';
        ENV.locationType = 'none';

        // keep test console output quieter
        ENV.APP.LOG_ACTIVE_GENERATION = false;
        ENV.APP.LOG_VIEW_LOOKUPS = false;

        ENV.APP.rootElement = '#ember-testing';
    }

    if (environment === 'production') {

    }

    ENV['simple-auth'] = {
        crossOriginWhitelist: [ENV.API_HOST],
        authorizer: 'simple-auth-authorizer:oauth2-bearer',
        routeAfterAuthentication: 'authority-based-router',
        routeIfAlreadyAuthenticated: 'authority-based-router'
    };

    ENV["simple-auth-oauth2"] = {
        serverTokenEndpoint: [ENV.API_HOST, 'oauth/login'].join('/')
    };

    return ENV;
};
