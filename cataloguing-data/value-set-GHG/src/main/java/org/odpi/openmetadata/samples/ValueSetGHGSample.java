/* SPDX-License-Identifier: Apache 2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.samples;


import org.odpi.openmetadata.http.HttpHelper;
import org.odpi.openmetadata.samples.utilities.SampleBase;

import java.io.IOException;

import static java.lang.System.exit;

/**
 * ValueSetGHGSample calls each of the samples from a main program.  It is used to load all of the metadata created
 * by the samples in a single run.
 */
public class ValueSetGHGSample extends SampleBase
{
    /**
     * Run the samples.
     *
     * @param serverName name of the server to connect to
     * @param serverPlatformRootURL the network address of the server running the OMAS REST servers
     * @param userId calling user
     */
    public void runSample(String serverName,
                          String serverPlatformRootURL,
                          String userId)
    {
        /* todo add code here */
    }


    /**
     * Run the Sample Suite.
     *
     * @param args user input
     */
    public static void main(String[] args)
    {
        HttpHelper.noStrictSSLIfConfigured();

        int exitCode = 0;

        try
        {
            String url = getUrl(args);
            String serverName = getServerName(args);
            String userId = getUserId(args);

            SamplesEnsemble samplesSuite = new SamplesEnsemble();

            samplesSuite.runSample(serverName, url, userId);
        }
        catch (IOException error)
        {
            System.out.println("Error getting user input");
            error.printStackTrace();
            exitCode = -99;
        }

        exit(exitCode);
    }
}
