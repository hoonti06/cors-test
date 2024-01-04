# CORS 테스트

## docker 전체 실행
```sh
$ docker-compose up -d
```

1. 브라우저로 `localhost:8888/hello/hi` 접속
2. `다음` 버튼 클릭
3. `Invalid CORS request` 화면 출력 확인

## local
```sh
$ docker-compose -f docker-compose-local.yml up -d
```

1. CorsTestApplication 실행
1. 브라우저로 `localhost:8887/hello/hi` 접속
2. `다음` 버튼 클릭
3. `Invalid CORS request` 화면 출력 확인


## Description (local 기준)
nginx는 특정 URL(/hello/hi)로 접속 시 spring application으로 reverse pass를 해주는 reverse proxy 역할을 한다.  
이때, nginx로 접속하는 것이기 때문에 `origin` 헤더의 값은 nginx의 host인 `http://localhost:8887` 이다.  
하지만, request url은 reverse pass되는 `http://host.docker.internal:8080` 이다.
이로 인해, springframework.web.cors.CorsUtils.isCorsRequest()에서 CORS라고 판단한다.  
![local-is-cors-request.png](img%2Flocal-is-cors-request.png)

<br>

CORS로 판단된다면 `origin` 헤더가 allowed origins에 포함되어 있는지 검증을 하는데,  
`http://localhost:8887`는 포함되어 있지 않아 http status code가 403으로 설정된다.