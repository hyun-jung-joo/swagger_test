package com.example.swaggerPractice1.config;
//Swagger 설정 부분

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiV1(){ // Docket : Swagger 설정을 할 수 있게 도와주는 클래스
        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(this.apiInfo1())
                .groupName("groupName1")
                //groupName : 만약 Bean이 하나라면 생략가능 / 여러 개면 명시해주고 이름 붙여주기 (충돌 방지)
                .select()
                //select() : ApiSelectorBuilder를 생성하여 apis()와 paths() 를 사용할 수 있게 해줌
                .apis(RequestHandlerSelectors.
                        basePackage("com.example.swaggerPractice1.controller"))
                //apis() : api가 작성되있는 패키지 지정  -> 컨트롤러 지정
                .paths(PathSelectors.ant("/posts/**")).build();
                //paths() : apis()로 선택된 API중 원하는 path를 지정하여 문서화
                // 현재 -> PathSelectors.ant("/posts/**") 이므로 /posts 에 관한 API를 문서화해서 볼 수 있다
                // PathSelectors.any() 로 설정 시 ; 패키지 안에 모든 API를 한 번에 볼 수 있다 -> API가 많아지면 보기 힘들다
    }

    // ApiInfo : 원하는 데로 커스텀 하기 ! - 생성자 파라미터 정해져 있다
    // 다른 사람의 예시입니다.
//    private ApiInfo apiInfo1() {
//        return new ApiInfo(
//                "title", // title 부분 : 문자열
//                "description", // 설명 : 문자열
//                "version", // 버전 : 문자열
//                "https://velog.io/@tigger", // String termsOfServicceUrl : Terms of service를 클릭했을 때 보내고 싶은 url
//                new Contact("Contact Me", "https://velog.io/@tigger", "tigger@tigger.com"), // Contact contact : 파라미터 3개 -> 두 줄로 나옴
                    // 1 번 파라미터 : 문자열 -> 설명 문자열 같은거 (또는 제목)
                    // 2번 파라미터 : contact의 첫번째 url
                    // 3번 파라미터 : 이메일 주소
//                "tigger Licenses", // String license : 화면에 명시(url의 이름처럼)
//                "https://github.com/kimevanjunseok", // String licenseUrl : 클릭하면 url로 이동
//                new ArrayList<>() // Collection<VendorExtension> vendorExtensions :
//        );
//    }

    @Bean
    public Docket apiV2(){
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                // useDefaultResponseMessages : false로 설정하면 불필요한 응답코드와 설명을 제거
                .groupName("groupName2")
                .select()
                .apis(RequestHandlerSelectors.
                        basePackage("com.example.swaggerPractice1.controller"))
                .paths(PathSelectors.ant("/posts/**")).build();
    }
}