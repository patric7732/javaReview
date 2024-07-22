package org.example.githubclient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class GitHubApiService {
    private final RestTemplate restTemplate;
    @Value("${github.api.url}")
    private String githubApiUrl;
    @Value("${github.api.token}")
    private String githubApiToken;
    public GitHubApiService() {
        this.restTemplate = new RestTemplate();
    }
    public String getUserRepos(String username) {
        String url = githubApiUrl + "/users/" + username + "/repos";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + githubApiToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }
}
