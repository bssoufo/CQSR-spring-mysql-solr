package com.brunosoufo.cqsr.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(
  basePackages = "com.brunosoufo.cqsr.repositories.solr"
  /*, namedQueriesLocation = "classpath:solr-named-queries.properties"*/)
@ComponentScan
public class SolrConfig {
 
    @Bean
    public SolrClient solrClient() {
        List<String> zkHosts = new ArrayList<>();
        Optional<String> zkChroot = Optional.empty();;
        zkHosts.add("localhost:9983");
        CloudSolrClient.Builder builder = new CloudSolrClient.Builder(zkHosts,zkChroot);
        SolrClient client = builder.build();
        return client;
    }
 
    @Bean
    public SolrTemplate solrTemplate(SolrClient client) throws Exception {
        return new SolrTemplate(client);
    }
}