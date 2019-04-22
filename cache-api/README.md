1. Making cache configurable , don’t need deployment if want to increase size of cache.
2. Two Endpoint are exposed - http://localhost:9000/api/v1/put/3?value=1200, http://localhost:9000/api/v1/get/1
3. Added additional features to help you monitor and manage your application when you push it to production. 

   http://localhost:9000/actuator

    ENDPOINTS	USAGE
    /metrics	To view the application metrics such as memory used, memory free, threads, classes, system uptime etc.
    /env	    To view the list of Environment variables used in the application.
    /beans	    To view the Spring beans and its types, scopes and dependency.
    /health	    To view the application health
    /info	    To view the information about the Spring Boot application.
    /trace	    To view the list of Traces of your Rest endpoints.

4. How to run

    Project folder and run command
        ./gradlew bootRun

