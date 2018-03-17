package com.myretail.cassandra.config;

/**
 * Project: tar-cassandra-parent
 * Package: com.myretail.cassandra.config
 * <p>
 * User: vthalapu
 * Date: 3/17/18
 * Time: 10:47 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */

////Approach -> 1
//@Configuration
//public class AppConfig {
//
//    /*
//     * Use the standard Cassandra driver API to create a com.datastax.driver.core.Session instance.
//     */
//    public @Bean
//    Session session() {
//        Cluster cluster = Cluster.builder().addContactPoints("localhost").build();
//        return cluster.connect("mykeyspace");
//    }
//}

//Approach -> 2

//@Configuration
//public class AppConfig {
//
//    /*
//     * Factory bean that creates the com.datastax.driver.core.Session instance
//     */
//    @Bean
//    public CassandraCqlClusterFactoryBean cluster() {
//
//        CassandraCqlClusterFactoryBean cluster = new CassandraCqlClusterFactoryBean();
//        cluster.setContactPoints("localhost");
//
//        return cluster;
//    }
//
//    /*
//     * Factory bean that creates the com.datastax.driver.core.Session instance
//     */
//    @Bean
//    public CassandraCqlSessionFactoryBean session() {
//
//        CassandraCqlSessionFactoryBean session = new CassandraCqlSessionFactoryBean();
//        session.setCluster(cluster().getObject());
//        session.setKeyspaceName("mykeyspace");
//
//        return session;
//    }
//}


//Approach -> 3
//@Configuration
//public class AppConfig extends AbstractCassandraConfiguration {
//
//    /*
//     * Provide a contact point to the configuration.
//     */
//    public String getContactPoints() {
//        return "localhost";
//    }
//
//    /*
//     * Provide a keyspace name to the configuration.
//     */
//    public String getKeyspaceName() {
//        return "mykeyspace";
//    }
//}