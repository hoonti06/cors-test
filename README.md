# CORS 테스트

## docker 실행
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
