package com.mycompany.launcher;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by starfucker on 03/07/2017.
 * Entry point used for standalone launching web application under Tomcat
 */
public class ServiceLauncher {
    private static final Logger LOG = LoggerFactory.getLogger(ServiceLauncher.class);

    public static void main(String[] args) throws ServletException, LifecycleException {
        final Tomcat tomcat = new Tomcat();
        final Path path = Paths.get("src/main/webapp/");
        final Context context = tomcat.addWebapp("/", path.toAbsolutePath().toString());

        LOG.info("Configuring app with basedir {}", path);

        final Path additionClassesPath = Paths.get("target/classes");
        final WebResourceRoot resourceRoot = new StandardRoot(context);
        final DirResourceSet resources = new DirResourceSet(
            resourceRoot, "/WEB-INF/classes", additionClassesPath.toAbsolutePath().toString(), "/"
        );
        resourceRoot.addPreResources(resources);
        context.setResources(resourceRoot);

        tomcat.setPort(8080);
        tomcat.setBaseDir("build/");
        tomcat.start();
        tomcat.getServer().await();

        LOG.info("Application started");
    }
}
