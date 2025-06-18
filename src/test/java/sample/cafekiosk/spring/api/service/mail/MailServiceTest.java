package sample.cafekiosk.spring.api.service.mail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import sample.cafekiosk.spring.client.mail.MailSendClient;
import sample.cafekiosk.spring.domain.history.mail.MailSendHistory;
import sample.cafekiosk.spring.domain.history.mail.MailSendHistoryRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MailServiceTest {

    @Spy
    private MailSendClient mailSendClientSpy;

    @Mock
    private MailSendClient mailSendClient;

    @Mock
    private MailSendHistoryRepository mailSendHistoryRepository;

    @InjectMocks
    private MailService mailService;

    @DisplayName("메일 전송을 할 수 있다.")
    @Test
    void sendMail() {
        // given
        MailSendClient mailSendClient = Mockito.mock(MailSendClient.class);
        MailSendHistoryRepository mailSendHistoryRepository = Mockito.mock(MailSendHistoryRepository.class);
        MailService mailService = new MailService(mailSendClient, mailSendHistoryRepository);

        when(mailSendClient.sendMail(anyString(), anyString(), anyString(), anyString()))
                .thenReturn(true);

        // when
        boolean isSent = mailService.sendMail("", "", "", "");

        // then
        assertThat(isSent).isTrue();
        Mockito.verify(mailSendHistoryRepository, times(1)).save(any(MailSendHistory.class));
    }

    @DisplayName("메일 전송을 할 수 있다.")
    @Test
    void sendMail2() {
        // given
        when(mailSendClient.sendMail(anyString(), anyString(), anyString(), anyString()))
                .thenReturn(true);

        // when
        boolean isSent = mailService.sendMail("", "", "", "");

        // then
        assertThat(isSent).isTrue();
        Mockito.verify(mailSendHistoryRepository, times(1)).save(any(MailSendHistory.class));
    }


    @DisplayName("메일 전송을 할 수 있다.")
    @Test
    void sendMail3() {
        // given
        Mockito.doReturn(true)
                .when(mailSendClientSpy)
                .sendMail(anyString(), anyString(), anyString(), anyString());

        // when
        boolean isSent = mailService.sendMail("", "", "", "");

        // then
        assertThat(isSent).isTrue();
        Mockito.verify(mailSendHistoryRepository, times(1)).save(any(MailSendHistory.class));
    }
}