package com.restassured;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        OMDB omdb = new OMDB();
        omdb.getOMDB();

        ReqRes reqRes = new ReqRes();
        reqRes.getReqRes();
        reqRes.postReqRes();
        reqRes.patchReqRes();
        reqRes.putReqRes();
    }
}
