package com.example.KimJeongYong.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.logging.Logger;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "quoteApi",
        version = "v1",
        resource = "quote",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.KimJeongYong.example.com",
                ownerName = "backend.myapplication.KimJeongYong.example.com",
                packagePath = ""
        )
)
public class QuoteEndpoint {

    private static final Logger logger = Logger.getLogger(QuoteEndpoint.class.getName());

    /**
     * This method gets the <code>Quote</code> object associated with the specified <code>id</code>.
     *
     * @param id The id of the object to be returned.
     * @return The <code>Quote</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getQuote")
    public Quote getQuote(@Named("id") Long id) {
        // TODO: Implement this function
        logger.info("Calling getQuote method");
        return null;
    }

    /**
     * This inserts a new <code>Quote</code> object.
     *
     * @param quote The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertQuote")
    public Quote insertQuote(Quote quote) {
        // TODO: Implement this function
        logger.info("Calling insertQuote method");
        return quote;
    }
}