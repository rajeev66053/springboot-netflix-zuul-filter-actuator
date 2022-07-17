# springboot-netflix-zuul-filter-actuator 

* There are different type of zuul filter. They are:
    1. Pre filter
    2. Post filter
    3. route filter
    4. error filter
    5. custom filter

* Characterstics of filter:
    1. Type	- filterType() method
    2. ExecutionOrder - filterOrder() method
    3. Criteria - shouldFilter() method
    4. Action - run() method
  
* Post filter is execute after pre filter.
* Route filter is execute after pre filter and before post filter.

* Actual flow is PreFilter -RouteFilter -ActualService-PostFilter. In between this if error occur then errorFilter will execute.

* When we run all the services and api-gateway and execute `http://localhost:8100/doctor-service/doctors` we can see order of filter in console:

* For actutator endpoint
  >http://localhost:8100/actuator
  
* For routes endpoint
  > http://localhost:8100/actuator/routes
  
* For more details about the routefilter
  > http://localhost:8100/actuator/routes/details
  

* For filters endpoint
  > http://localhost:8100/actuator/filters