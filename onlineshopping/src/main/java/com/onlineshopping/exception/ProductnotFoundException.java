package com.onlineshopping.exception;

import java.io.Serializable;

public class ProductnotFoundException extends Exception implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String message;

    public ProductnotFoundException()
    {
	this("This Product is not Found");
    }

    public ProductnotFoundException(String message)
    {
	this.message = System.currentTimeMillis() + " :" + message;
    }

    public String getMessage()
    {
	return message;
    }

    public void setMessage(String message)
    {
	this.message = message;
    }

}
