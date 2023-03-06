package com.pccw.platform.provider.client;

import com.alibaba.fastjson.JSON;
import com.pccw.platform.service.model.ConsoleCoreException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Slf4j
@Service
public abstract class CommonWebClient {
  @Autowired private WebClient client;
  private Header authHeader = new BasicHeader("auth", "Bearer");

  public abstract void refeshToken();

  public abstract boolean shouldRefeshToken(WebClientResponseException ex);

  public void setAuthHeader(Header authHeader) {
    this.authHeader = authHeader;
  }

  public ResponseSpec curl(String url, HttpMethod method, Object body) {
    log.info("{} {}", method, url);

    RequestBodySpec resSpec =
        client
            .method(method)
            .uri(url)
            .header(authHeader.getName(), authHeader.getValue())
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON);

    if (body != null) {
      if (body instanceof String) {
        log.info("{}", body);
      } else {
        log.info("{}", JSON.toJSONString(body));
      }
      return resSpec.bodyValue(body).retrieve();
    } else {
      return resSpec.retrieve();
    }
  }

  @SneakyThrows
  public <T> T get(String url, Class<T> responseType) {
    return get(url, responseType, true);
  }

  @SneakyThrows
  public <T> T get(String url, Class<T> responseType, boolean retry) {
    try {
      return curl(url, HttpMethod.GET, null).bodyToMono(responseType).block();
    } catch (WebClientResponseException ex) {
      if (retry && shouldRefeshToken(ex)) {
        refeshToken();
        return get(url, responseType, false);
      } else {
        logException(ex);
        throw new ConsoleCoreException(ex.getStatusCode().value(), ex.getResponseBodyAsString());
      }
    }
  }

  @SneakyThrows
  public <T> T get(String url, ParameterizedTypeReference<T> responseType) {
    return get(url, responseType, true);
  }

  @SneakyThrows
  public <T> T get(String url, ParameterizedTypeReference<T> responseType, boolean retry) {
    try {
      return curl(url, HttpMethod.GET, null).bodyToMono(responseType).block();
    } catch (WebClientResponseException ex) {
      if (retry && shouldRefeshToken(ex)) {
        refeshToken();
        return get(url, responseType, false);
      } else {
        logException(ex);
        throw new ConsoleCoreException(ex.getStatusCode().value(), ex.getResponseBodyAsString());
      }
    }
  }

  @SneakyThrows
  public <T> T post(String url, Object body, Class<T> responseType) {
    return post(url, body, responseType, true);
  }

  @SneakyThrows
  public <T> T post(String url, Object body, Class<T> responseType, boolean retry) {
    try {
      return curl(url, HttpMethod.POST, body).bodyToMono(responseType).block();
    } catch (WebClientResponseException ex) {
      if (retry && shouldRefeshToken(ex)) {
        refeshToken();
        return post(url, body, responseType, false);
      } else {
        logException(ex);
        throw new ConsoleCoreException(ex.getStatusCode().value(), ex.getResponseBodyAsString());
      }
    }
  }

  @SneakyThrows
  public <T> T post(String url, Object body, ParameterizedTypeReference<T> responseType) {
    return post(url, body, responseType, true);
  }

  @SneakyThrows
  public <T> T post(
      String url, Object body, ParameterizedTypeReference<T> responseType, boolean retry) {
    try {
      return curl(url, HttpMethod.POST, body).bodyToMono(responseType).block();
    } catch (WebClientResponseException ex) {
      if (retry && shouldRefeshToken(ex)) {
        refeshToken();
        return post(url, body, responseType, false);
      } else {
        logException(ex);
        throw new ConsoleCoreException(ex.getStatusCode().value(), ex.getResponseBodyAsString());
      }
    }
  }

  @SneakyThrows
  public <T> T patch(String url, Object body, Class<T> responseType) {
    return patch(url, body, responseType, true);
  }

  @SneakyThrows
  public <T> T patch(String url, Object body, Class<T> responseType, boolean retry) {
    try {
      return curl(url, HttpMethod.PATCH, body).bodyToMono(responseType).block();
    } catch (WebClientResponseException ex) {
      if (retry && shouldRefeshToken(ex)) {
        refeshToken();
        return patch(url, body, responseType, false);
      } else {
        logException(ex);
        throw new ConsoleCoreException(ex.getStatusCode().value(), ex.getResponseBodyAsString());
      }
    }
  }

  @SneakyThrows
  public <T> T patch(String url, Object body, ParameterizedTypeReference<T> responseType) {
    return patch(url, body, responseType, true);
  }

  @SneakyThrows
  public <T> T patch(
      String url, Object body, ParameterizedTypeReference<T> responseType, boolean retry) {
    try {
      return curl(url, HttpMethod.PATCH, body).bodyToMono(responseType).block();
    } catch (WebClientResponseException ex) {
      if (retry && shouldRefeshToken(ex)) {
        refeshToken();
        return patch(url, body, responseType, false);
      } else {
        logException(ex);
        throw new ConsoleCoreException(ex.getStatusCode().value(), ex.getResponseBodyAsString());
      }
    }
  }

  @SneakyThrows
  public <T> T delete(String url, Class<T> responseType) {
    return delete(url, responseType, true);
  }

  @SneakyThrows
  public <T> T delete(String url, Class<T> responseType, boolean retry) {
    try {
      return curl(url, HttpMethod.DELETE, null).bodyToMono(responseType).block();
    } catch (WebClientResponseException ex) {
      if (retry && shouldRefeshToken(ex)) {
        refeshToken();
        return delete(url, responseType, false);
      } else {
        logException(ex);
        throw new ConsoleCoreException(ex.getStatusCode().value(), ex.getResponseBodyAsString());
      }
    }
  }

  @SneakyThrows
  public <T> T delete(String url, ParameterizedTypeReference<T> responseType) {
    return delete(url, responseType, true);
  }

  @SneakyThrows
  public <T> T delete(String url, ParameterizedTypeReference<T> responseType, boolean retry) {
    try {
      return curl(url, HttpMethod.DELETE, null).bodyToMono(responseType).block();
    } catch (WebClientResponseException ex) {
      if (retry && shouldRefeshToken(ex)) {
        refeshToken();
        return delete(url, responseType, false);
      } else {
        logException(ex);
        throw new ConsoleCoreException(ex.getStatusCode().value(), ex.getResponseBodyAsString());
      }
    }
  }

  private static void logException(WebClientResponseException ex) {
    log.error("message:{}", ex.getMessage());
    log.error("statusCode:{}", ex.getStatusCode());
    log.error("responseBodyAsString:{}", ex.getResponseBodyAsString());
  }
}
