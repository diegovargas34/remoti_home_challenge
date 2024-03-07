# Home Challenge - Performance


* For the performance testing part of the challenge, k6 and JavaScript were used to perform 3 different tests on the Pet store API:

1. Load Test: to test the behavior of the API with several requests at the same time. A threshold was defined to test that the responses didn't take much more than a specific time. The result showed that some requests indeed took more time than expected:

![alt text](/screenshots/load-test-result.png)

2. Stress Test: to test the resilience of the app during extended periods of time with several requests at the same time. The result showed some requests again taking more time than what was expected:

![alt text](/screenshots/stress-test-result.png)

3. Spike Test: to test a sudden rise in several requests done at the same time. The result was inconclusive, as host was unreachable.


Command to run tests (like this for each of the files):

```
k6 run load-test.js
```
