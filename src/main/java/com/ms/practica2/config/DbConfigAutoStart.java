package com.ms.practica2.config;


import com.datastax.driver.core.ProtocolVersion;
import com.datastax.driver.core.SocketOptions;
import com.datastax.driver.core.policies.ConstantReconnectionPolicy;
import com.datastax.driver.core.policies.DefaultRetryPolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;


@Configuration
public class DbConfigAutoStart extends AbstractCassandraConfiguration {

    @Bean
    public CassandraClusterFactoryBean cluster() {

        SocketOptions socketOptions = new SocketOptions().setReadTimeoutMillis(100000);

        CassandraClusterFactoryBean bean = super.cluster();
        bean.setContactPoints("bscassandra");
        bean.setPort(9042);
        bean.setJmxReportingEnabled(false);
        bean.setMetricsEnabled(false);
        bean.setRetryPolicy(DefaultRetryPolicy.INSTANCE);
        bean.setProtocolVersion(ProtocolVersion.V4);
        bean.setSocketOptions(socketOptions);
        bean.setReconnectionPolicy(new ConstantReconnectionPolicy(1000));

        return bean;
    }
    @Bean
    public CassandraMappingContext cassandraMapping()
            throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }
    @Override
    protected String getKeyspaceName() {
        return "personadatabase";
    }
}