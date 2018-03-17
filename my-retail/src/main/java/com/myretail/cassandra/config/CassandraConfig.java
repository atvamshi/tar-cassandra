package com.myretail.cassandra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;

import java.util.Arrays;
import java.util.List;

/**
 * Project: tar-cassandra-parent
 * Package: com.myretail.cassandra.config
 * <p>
 * User: vthalapu
 * Date: 3/17/18
 * Time: 10:52 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */

//Approach -> 1

//@Configuration
//@EnableCassandraRepositories(basePackages = { "com.myretail" })
//public class CassandraConfig {
//
//    @Bean
//    public CassandraClusterFactoryBean cluster() {
//
//        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
//        cluster.setContactPoints("localhost");
//
//        return cluster;
//    }
//
//    @Bean
//    public CassandraMappingContext mappingContext() {
//
//        BasicCassandraMappingContext mappingContext =  new BasicCassandraMappingContext();
//        mappingContext.setUserTypeResolver(new SimpleUserTypeResolver(cluster().getObject(), "mykeyspace"));
//
//        return mappingContext;
//    }
//
//    @Bean
//    public CassandraConverter converter() {
//        return new MappingCassandraConverter(mappingContext());
//    }
//
//    @Bean
//    public CassandraSessionFactoryBean session() throws Exception {
//
//        CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
//        session.setCluster(cluster().getObject());
//        session.setKeyspaceName("mykeyspace");
//        session.setConverter(converter());
//        session.setSchemaAction(SchemaAction.NONE);
//
//        return session;
//    }
//
//    @Bean
//    public CassandraOperations cassandraTemplate() throws Exception {
//        return new CassandraTemplate(session().getObject());
//    }
//}

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    public static final String KEYSPACE = "mykeyspace";

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        CreateKeyspaceSpecification specification = CreateKeyspaceSpecification.createKeyspace(KEYSPACE);

        return Arrays.asList(specification);
    }

    @Override
    protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
        return Arrays.asList(DropKeyspaceSpecification.dropKeyspace(KEYSPACE));
    }

    @Override
    protected String getKeyspaceName() {
        return KEYSPACE;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.myretail"};
    }
}