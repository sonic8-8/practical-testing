package sample.cafekiosk.spring.client.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MailSendClient {

    /**
     * Mockito를 통해 메일 전송 서비스를 Mocking 처리하는 경우,
     * 원하는 행위나 결과를 마음대로 정의할 수 있다는 예시를 보여주기 위해
     * 예외를 던지는 방식으로 구현했습니다. (= stubbing)
     *
     * 원하는 결과: 예외가 발생하지 않도록 true를 반환한다.
     */
    public boolean sendMail(String fromEmail, String toEmail, String subject, String content) {
        log.info("메일 전송");
        throw new IllegalArgumentException("메일 전송");
    }

    /**
     * 테스트 더블 개념 중 Spy를 알아보기 위해
     * 단순히 로그를 찍는 메서드를 추가합니다.
     * 로그를 찍는 메서드만 실제 기능을 수행합니다.
     */
    public void a() {
        log.info("a");
    }

    public void b() {
        log.info("b");
    }

    public void c() {
        log.info("c");
    }
}
