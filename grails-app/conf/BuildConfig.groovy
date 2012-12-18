grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.plugin.repos.distribution.suGrailsPlugins = "svn+ssh://svn.it.su.se/svn/grails-plugins/"
grails.plugin.repos.discovery.suGrailsPlugins = "http://svn.it.su.se/grails-plugins/"
grails.project.repos.default = 'suGrailsPlugins'
grails.release.scm.enabled = false
grails.project.docs.output.dir = 'docs' // for the gh-pages branch

//grails.tomcat.jvmArgs = ["-Xmx1024m","-Xms512m", "-agentpath:C:\\Program Files (x86)\\YourKit Java Profiler 9.0.9\\bin\\win64\\yjpagent.dll=sampling,onexit=snapshot"]

//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        runtime "org.elasticsearch:elasticsearch:0.20.1"
        runtime "org.elasticsearch:elasticsearch-lang-groovy:1.1.0"
    }
    plugins {
        build (":release:latest.integration") {
            export = false
        }
        test (":spock:0.7") {
            export = false
        }
    }
}
