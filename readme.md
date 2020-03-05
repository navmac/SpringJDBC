Class Notes on 4-March-2020
===========================

Required Software:
=================

1. Verify STS (Spring Tool Suite) =  IDE

2. Check the ORACLE DB installation

	You just need username & password for ORACLE
	DB VERSION 11.2.0.2.0

	system/Password123

	sqlplus system/Password123@xe
	SQL>

	9.42
	9.52

	Windows password: admin@123

	sqlplus system/Password123@xe

------------------

Pre-reqsuite for attending this training:

1. Should have sufficient project experience
2. Basics of SPRING 

Day 1: Spring Boot
	 
	   a. Without DB
	   b. Using ORACLE DB

Develop CRUD application using Spring Boot

Day 2: Microservices

How to build Microservices Architected based aplication using Spring Boot

Create couple of microservices and deploy them into Eureka server
How to make them to communicate with each other (Microservices communication)

Why spring?

1. Loosely coupled framework
2. XML configuration
3. Faster
4. Light weight
5. Model View Controller (MVC)
6. Service layer (decoupling layers and maintaining the code easily)


MVC stands for Model View Controller

M - Model - Anything related to DATA (POJO, state manipulation, JDBC program, ...), Business Logic
V - View - UI (Presentation, pie chart, bar chart, HTML table, analytics, reports....)
		visual representaion of model (HTML, CSS, Javascript, jQuery, Angular, React, Knockout, OJET, JSP...)
C - Controller - Request handler
MVC can be applied to any type of applications
 - Stand alone
- web app
- RESTful app
- mobile app
-any application

Controller controls all activities inside the application

Example:
	A client sends 2 numbers for adding them

       Servlets receives the data
       It can do some kind of input validations (data is number? date type, checks for validity)
       It can forwards the data to another program that executes the business logic ( x+ y)
       This program send the result (addition) to the servlet again
        Now, the servlet has Input and Output
        Now, it will look for other / another program that does the formatting
         (colors, font size, background, adding images, audio....)
        We have JSP (Java Server Pages) that takes the data and does all kinds of
			formatting 


In MVC, Control doesn't do anything other than coordination
Without the knowledge of the Controller, nothing happens in the application

Also, you would have heard about another term "SERVICE LAYER"

It's a program with lots of methods, each method provides one service

class EmployeeService
{

	public List<Employee> getAllEmployees()
	{
		....
		....
		....
		You can also modify the data after you receive from DB
	}


}

In Spring Boot, we won't be required to do any configurations.
Spring Boot will take care of all the configurations and dependency management of libaries (.jar files)
  
Activity 1:

1. Create a maven project "TestMaven"
2. Open pom.xml

https://mvnrepository.com (central repository)

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.ofss</groupId>
  <artifactId>TestMaven2</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  

  
  <dependencies>
  <!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
<dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework.data/spring-data-mongodb -->

    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-mongodb</artifactId>
    <version>2.2.5.RELEASE</version>
</dependency>

  </dependencies>
</project>


   <parent>
  	<groupId>org.springframework.boot</groupId>
  	<artifactId>spring-boot-starter-parent</artifactId>
  	<version>1.4.2.RELEASE</version>
  </parent>

  <dependencies>
   <!-- https://mvnrepository.com/artifact/org.mongodb/mongodb-driver -->
 <dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
  </dependency>

What about settings.xml file?

Sometimes, we work in the company's setup, they have firewall servers installed
This will block us from downloding the .jar files from maven central repo

In this cases, you need to create a settings.xml with following contents:

<?xml version="1.0" encoding="UTF-8"?>

<!-- save "settings.xml" file under .m2 folder (user home directory) -->
<!--
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
-->

<!--
 | This is the configuration file for Maven. It can be specified at two levels:
 |
 |  1. User Level. This settings.xml file provides configuration for a single user,
 |                 and is normally provided in ${user.home}/.m2/settings.xml.
 |
 |                 NOTE: This location can be overridden with the CLI option:
 |
 |                 -s /path/to/user/settings.xml
 |
 |  2. Global Level. This settings.xml file provides configuration for all Maven
 |                 users on a machine (assuming they're all using the same Maven
 |                 installation). It's normally provided in
 |                 ${maven.conf}/settings.xml.
 |
 |                 NOTE: This location can be overridden with the CLI option:
 |
 |                 -gs /path/to/global/settings.xml
 |
 | The sections in this sample file are intended to give you a running start at
 | getting the most out of your Maven installation. Where appropriate, the default
 | values (values used when the setting is not specified) are provided.
 |
 |-->
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <!-- localRepository
   | The path to the local repository maven will use to store artifacts.
   |
   | Default: ${user.home}/.m2/repository
  <localRepository>/path/to/local/repo</localRepository>
  -->

  <!-- interactiveMode
   | This will determine whether maven prompts you when it needs input. If set to false,
   | maven will use a sensible default value, perhaps based on some other setting, for
   | the parameter in question.
   |
   | Default: true
  <interactiveMode>true</interactiveMode>
  -->

  <!-- offline
   | Determines whether maven should attempt to connect to the network when executing a build.
   | This will have an effect on artifact downloads, artifact deployment, and others.
   |
   | Default: false
  <offline>false</offline>
  -->

  <!-- pluginGroups
   | This is a list of additional group identifiers that will be searched when resolving plugins by their prefix, i.e.
   | when invoking a command line like "mvn prefix:goal". Maven will automatically add the group identifiers
   | "org.apache.maven.plugins" and "org.codehaus.mojo" if these are not already contained in the list.
   |-->
  <pluginGroups>
    <!-- pluginGroup
     | Specifies a further group identifier to use for plugin lookup.
    <pluginGroup>com.your.plugins</pluginGroup>
    -->
  </pluginGroups>

  <!-- proxies
   | This is a list of proxies which can be used on this machine to connect to the network.
   | Unless otherwise specified (by system property or command-line switch), the first proxy
   | specification in this list marked as active will be used.
   |-->
  <proxies>
    <!-- proxy
     | Specification for one proxy, to be used in connecting to the network.
     |-->

    <proxy>
      <id>myproxy</id>
      <active>true</active>
      <protocol>HTTPS</protocol>
      <host>your proxy server name</host>
      <port>80</port>
     </proxy>

	     <proxy>
      <id>myproxy1</id>
      <active>true</active>
      <protocol>HTTP</protocol>
      <host>your proxy server name</host>
      <port>80</port>
     </proxy>

  </proxies>

  <!-- servers
   | This is a list of authentication profiles, keyed by the server-id used within the system.
   | Authentication profiles can be used whenever maven must make a connection to a remote server.
   |-->
  <servers>
    <!-- server
     | Specifies the authentication information to use when connecting to a particular server, identified by
     | a unique name within the system (referred to by the 'id' attribute below).
     |
     | NOTE: You should either specify username/password OR privateKey/passphrase, since these pairings are
     |       used together.
     |
    <server>
      <id>deploymentRepo</id>
      <username>repouser</username>
      <password>repopwd</password>
    </server>
    -->

	<server>
     <id>azure-auth</id>
      <configuration>
         <client>1561e957-7a50-4e90-bfc8-085bdc244a2a</client>
         <tenant>b712de06-3ee9-44c8-a0c9-dbd3c9e89c35</tenant>
         <key>c4629070-e21d-4c5a-9492-3a0dd1ca880a</key>
         <environment>AZURE</environment>
      </configuration>
   </server>

    <!-- Another sample, using keys to authenticate.
    <server>
      <id>siteServer</id>
      <privateKey>/path/to/private/key</privateKey>
      <passphrase>optional; leave empty if not used.</passphrase>
    </server>
    -->
  </servers>

  <!-- mirrors
   | This is a list of mirrors to be used in downloading artifacts from remote repositories.
   |
   | It works like this: a POM may declare a repository to use in resolving certain artifacts.
   | However, this repository may have problems with heavy traffic at times, so people have mirrored
   | it to several places.
   |
   | That repository definition will have a unique id, so we can create a mirror reference for that
   | repository, to be used as an alternate download site. The mirror site will be the preferred
   | server for that repository.
   |-->
  <mirrors>
    <!-- mirror
     | Specifies a repository mirror site to use instead of a given repository. The repository that
     | this mirror serves has an ID that matches the mirrorOf element of this mirror. IDs are used
     | for inheritance and direct lookup purposes, and must be unique across the set of mirrors.
     |
    <mirror>
      <id>mirrorId</id>
      <mirrorOf>repositoryId</mirrorOf>
      <name>Human Readable Name for this Mirror.</name>
      <url>http://my.repository.com/repo/path</url>
    </mirror>
     -->
	 <!-- <mirror>
  <id>ibiblio.org</id>
  <url>http://mirrors.ibiblio.org/maven2</url>
  <mirrorOf>central</mirrorOf>
</mirror> -->
  </mirrors>

  <!-- profiles
   | This is a list of profiles which can be activated in a variety of ways, and which can modify
   | the build process. Profiles provided in the settings.xml are intended to provide local machine-
   | specific paths and repository locations which allow the build to work in the local environment.
   |
   | For example, if you have an integration testing plugin - like cactus - that needs to know where
   | your Tomcat instance is installed, you can provide a variable here such that the variable is
   | dereferenced during the build process to configure the cactus plugin.
   |
   | As noted above, profiles can be activated in a variety of ways. One way - the activeProfiles
   | section of this document (settings.xml) - will be discussed later. Another way essentially
   | relies on the detection of a system property, either matching a particular value for the property,
   | or merely testing its existence. Profiles can also be activated by JDK version prefix, where a
   | value of '1.4' might activate a profile when the build is executed on a JDK version of '1.4.2_07'.
   | Finally, the list of active profiles can be specified directly from the command line.
   |
   | NOTE: For profiles defined in the settings.xml, you are restricted to specifying only artifact
   |       repositories, plugin repositories, and free-form properties to be used as configuration
   |       variables for plugins in the POM.
   |
   |-->
  <profiles>
    <!-- profile
     | Specifies a set of introductions to the build process, to be activated using one or more of the
     | mechanisms described above. For inheritance purposes, and to activate profiles via <activatedProfiles/>
     | or the command line, profiles have to have an ID that is unique.
     |
     | An encouraged best practice for profile identification is to use a consistent naming convention
     | for profiles, such as 'env-dev', 'env-test', 'env-production', 'user-jdcasey', 'user-brett', etc.
     | This will make it more intuitive to understand what the set of introduced profiles is attempting
     | to accomplish, particularly when you only have a list of profile id's for debug.
     |
     | This profile example uses the JDK version to trigger activation, and provides a JDK-specific repo.
    <profile>
      <id>jdk-1.4</id>
      <activation>
        <jdk>1.4</jdk>
      </activation>
      <repositories>
        <repository>
          <id>jdk14</id>
          <name>Repository for JDK 1.4 builds</name>
          <url>http://www.myhost.com/maven/jdk14</url>
          <layout>default</layout>
          <snapshotPolicy>always</snapshotPolicy>
        </repository>
      </repositories>
    </profile>
    -->

    <!--
     | Here is another profile, activated by the system property 'target-env' with a value of 'dev',
     | which provides a specific path to the Tomcat instance. To use this, your plugin configuration
     | might hypothetically look like:
     |
     | ...
     | <plugin>
     |   <groupId>org.myco.myplugins</groupId>
     |   <artifactId>myplugin</artifactId>
     |
     |   <configuration>
     |     <tomcatLocation>${tomcatPath}</tomcatLocation>
     |   </configuration>
     | </plugin>
     | ...
     |
     | NOTE: If you just wanted to inject this configuration whenever someone set 'target-env' to
     |       anything, you could just leave off the <value/> inside the activation-property.
     |
    <profile>
      <id>env-dev</id>
      <activation>
        <property>
          <name>target-env</name>
          <value>dev</value>
        </property>
      </activation>
      <properties>
        <tomcatPath>/path/to/tomcat/instance</tomcatPath>
      </properties>
    </profile>
    -->
  </profiles>

  <!-- activeProfiles
   | List of profiles that are active for all builds.
   |
  <activeProfiles>
    <activeProfile>alwaysActiveProfile</activeProfile>
    <activeProfile>anotherAlwaysActiveProfile</activeProfile>
  </activeProfiles>
  -->
</settings>


Add Hibernate as a dependency
Save the project

3. Verify whether you have all .jar files related to Hibernate have been downloaded

11.17
Be back after 15 mins

Activity 2:

For a given URI "/hello", for HTTP method type "GET"
we should send the response "Hello Spring Boot"

package com.ofss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);

	}

}


package com.ofss;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String m1()
	{
		return "Hello Spring Boot";
	}
}


package com.ofss;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String m1()
	{
		return "Hello Spring Boot";
	}
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String m2()
	{
		return "Welcome";
	}
}


What is this?
@Autowired
	HelloService service;

Spring framework will scan all the classes with some type of configurational annotations

If it finds anything of this sort, then it will create an object of this class and inject into the place

class Hello
{

@Bean
public Employee m1()
{
	return new Employee();
}
}

@service:

Spring makes sure that you will get an object of that class
But singleton object


If you use any one of the above annotations, then you can autowire in your class

@Autowired
Hello h;

----

package com.ofss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	HelloService service;
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String m1()
	{
		System.out.println("currently in controller's m1 method");
		return service.xyz();
	}
	
	@RequestMapping(value="/welcome", method=RequestMethod.POST)
	public String m2()
	{
		return "Welcome";
	}
}



package com.ofss;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

	public String xyz()
	{
		System.out.println("in HelloService xyz method");
		return "Hello Spring Boot";
	}
}

Acitivity:

for the URI /customers

Return a list of Customer objects
Has many properties:
	custId
	custName
	custLocation

1. Create a POJO class Customer and the following properties

        custId
	custName
	custLocation

package com.ofss;

public class Customer {
	int custId;
	String custName;
	String custLocation;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int custId, String custName, String custLocation) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custLocation = custLocation;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustLocation() {
		return custLocation;
	}

	public void setCustLocation(String custLocation) {
		this.custLocation = custLocation;
	}
	
	
	
}


Spring Boot requires you to define DEFAULT CONSTRUCTOR


package com.ofss;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@RequestMapping(value="/customers", method=RequestMethod.GET)
	public List<Customer> allCustomers()
	{
		Customer c1=new Customer(1, "Guru", "Bangalore");
		Customer c2=new Customer(2, "Jack", "Mangalore");
		Customer c3=new Customer(3, "Peter", "Chennai");
		Customer c4=new Customer(4, "Hari", "Pune");
		Customer c5=new Customer(5, "Dhruv", "Mumbai");
		List<Customer> allCustomers=new ArrayList();
		allCustomers.add(c1);
		allCustomers.add(c2);
		allCustomers.add(c3);
		allCustomers.add(c4);
		allCustomers.add(c5);
		return allCustomers;
		
	}
}


2. How to return a single customer, given the customer id

URI:
	/customer/5 -> will return customer object with id "5"
	/customer/4 -> will return customer object with id "4"

HTTP method type: GET

	@RequestMapping(value="/customer/{custId}", method=RequestMethod.GET)
	public Customer oneCustomer(@PathVariable("custId") int cid)
	{
		System.out.println("Accepting the customer id "+cid);
		
		// write the logic to find out the customer obj for the given custid
		Customer c=new Customer(); // empty customer object
		
		for (Customer custTemp:allCustomers)
		{
			if (custTemp.getCustId()==cid)
			{
				c=custTemp;
				break;
				
			}
		}
		
		
		return c; // customer object matching the cust id
		
	}
	

Modified CustomerController.java

package com.ofss;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	List<Customer> allCustomers=new ArrayList();
	
	@Autowired
	CustomerService cs;
	
	@RequestMapping(value="/customers", method=RequestMethod.GET)
	public List<Customer> getAllCustomers()
	{
		return cs.getAllCustomers();
		
	}
	
	@RequestMapping(value="/customer/{custId}", method=RequestMethod.GET)
	public Customer getACustomer(@PathVariable("custId") int cid)
	{
		return cs.getACustomer(cid);
	}
	
}


CustomerService.java

package com.ofss;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	List<Customer> allCustomers=new ArrayList();
	
	public List<Customer> getAllCustomers()
	{
		Customer c1=new Customer(1, "Guru", "Bangalore");
		Customer c2=new Customer(2, "Jack", "Mangalore");
		Customer c3=new Customer(3, "Peter", "Chennai");
		Customer c4=new Customer(4, "Hari", "Pune");
		Customer c5=new Customer(5, "Dhruv", "Mumbai");
		
		allCustomers.add(c1);
		allCustomers.add(c2);
		allCustomers.add(c3);
		allCustomers.add(c4);
		allCustomers.add(c5);
		return allCustomers;
		
	}
	

	public Customer getACustomer(int cid)
	{
		System.out.println("Service: Accepting the customer id "+cid);
		
		// write the logic to find out the customer obj for the given custid
		Customer c=new Customer(); // empty customer object
		
		for (Customer custTemp:allCustomers)
		{
			if (custTemp.getCustId()==cid)
			{
				c=custTemp;
				break;
				
			}
		}
		
		
		return c; // customer object matching the cust id
		
	}
	
}
-

package com.ofss;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	List<Customer> allCustomers=new ArrayList();
	
	@Autowired
	CustomerService cs;
	
	@RequestMapping(value="/customers", method=RequestMethod.GET)
	public List<Customer> getAllCustomers()
	{
		return cs.getAllCustomers();
	}
	
	@RequestMapping(value="/customer/{custId}", method=RequestMethod.GET)
	public Customer getACustomer(@PathVariable("custId") int cid)
	{
		return cs.getACustomer(cid);
	}
	
	@RequestMapping(value="/customer/{custId}", method=RequestMethod.DELETE)
	public boolean deleteACustomer(@PathVariable("custId") int cid)
	{
		return cs.deleteACustomer(cid);
	}
	
	@RequestMapping(value="/customer/add", method=RequestMethod.POST)
	public String addACustomer(@RequestBody Customer cust)
	{
		return cs.addACustomer(cust);
	}
	
	
	
	
}


package com.ofss;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	List<Customer> allCustomers=new ArrayList();
	
	public List<Customer> getAllCustomers()
	{
		Customer c1=new Customer(1, "Guru", "Bangalore");
		Customer c2=new Customer(2, "Jack", "Mangalore");
		Customer c3=new Customer(3, "Peter", "Chennai");
		Customer c4=new Customer(4, "Hari", "Pune");
		Customer c5=new Customer(5, "Dhruv", "Mumbai");
		
		allCustomers.add(c1);
		allCustomers.add(c2);
		allCustomers.add(c3);
		allCustomers.add(c4);
		allCustomers.add(c5);
		return allCustomers;
		
	}
	

	public Customer getACustomer(int cid)
	{
		System.out.println("Service: Accepting the customer id "+cid);
		
		// write the logic to find out the customer obj for the given custid
		Customer c=new Customer(); // empty customer object
		
		for (Customer custTemp:allCustomers)
		{
			if (custTemp.getCustId()==cid)
			{
				c=custTemp;
				break;
				
			}
		}
		
		
		return c; // customer object matching the cust id
		
	}

	public boolean deleteACustomer(int cid)
	{
		System.out.println("Service: Accepting the customer id "+cid);
		boolean isDeleted=false;
		// write the logic to find out the customer obj for the given custid
		Customer c=new Customer(); // empty customer object
		
		for (Customer custTemp:allCustomers)
		{
			if (custTemp.getCustId()==cid)
			{
				c=custTemp;
				allCustomers.remove(custTemp);
				isDeleted=true;
				break;
				
			}
		}
		
		
		return isDeleted;
		
	}
	
	public String addACustomer(Customer customer)
	{
		allCustomers.add(customer);
		return customer.getCustName()+" added succesfully";
		
	}

	
}


CustomerService.java:

package com.ofss;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	List<Customer> allCustomers=new ArrayList();
	
	public List<Customer> getAllCustomers()
	{
		Customer c1=new Customer(1, "Guru", "Bangalore");
		Customer c2=new Customer(2, "Jack", "Mangalore");
		Customer c3=new Customer(3, "Peter", "Chennai");
		Customer c4=new Customer(4, "Hari", "Pune");
		Customer c5=new Customer(5, "Dhruv", "Mumbai");
		
		allCustomers.add(c1);
		allCustomers.add(c2);
		allCustomers.add(c3);
		allCustomers.add(c4);
		allCustomers.add(c5);
		return allCustomers;
		
	}
	

	public Customer getACustomer(int cid)
	{
		System.out.println("Service: Accepting the customer id "+cid);
		
		// write the logic to find out the customer obj for the given custid
		Customer c=new Customer(); // empty customer object
		
		for (Customer custTemp:allCustomers)
		{
			if (custTemp.getCustId()==cid)
			{
				c=custTemp;
				break;
				
			}
		}
		
		
		return c; // customer object matching the cust id
		
	}

	public boolean deleteACustomer(int cid)
	{
		System.out.println("Service: Accepting the customer id "+cid);
		boolean isDeleted=false;
		// write the logic to find out the customer obj for the given custid
		Customer c=new Customer(); // empty customer object
		
		for (Customer custTemp:allCustomers)
		{
			if (custTemp.getCustId()==cid)
			{
				c=custTemp;
				allCustomers.remove(custTemp);
				isDeleted=true;
				break;
				
			}
		}
		
		
		return isDeleted;
		
	}
	
	public String addACustomer(Customer customer)
	{
		allCustomers.add(customer);
		return customer.getCustName()+" added succesfully";
		
	}

	
}


Spring Boot - Database Programming:

1. You can use Spring JDBCTemplate (pre-defined)
	You don't know to worry about getting the connection, closing the db connection, creating the statement......
        You have to provide the SQL code

For this, let's create the employee table


2. You can use Spring JPA (Java Persistence API)
         It provides you all CRUD operations for FREE
Customer (Entity)

	JPA provides all CRUD operations
       You just need to invoke the respective methods (0 coding)

There is an interface called CrudRepository

		
The SQL code for creating employee table with primary key:

sqlplus system/Password123@xe

create table employee(firstname varchar2(20) primary key,  lastname varchar2(20),  phonenumber number(10),  emailid varchar2(20));

Spring Boot with JDBC Template:

1. Create a spring starter project
name: SpringBoot-JDBC

Download ojdbc6.jar from the following website
https://www.oracle.com/technetwork/apps-tech/jdbc-112010-090769.html

When we specify any dependency in pom.xml, maven starts looking for the .jar files in the following order:

1. local repo (.m2)
2. remote repo (your org. should maintain this server)
3. central repo (maven repository website)

You can manually download that particular file
go to the directory/folder, where you have downloaded this file
Give the following maven command that will install this .jar file into .m2 folder

mvn install:install-file -Dfile=ojdbc6.jar -DgroupId=com.oracle -DartifactId=oracle -Dversion=11.2.0.2.0 -Dpackaging=jar -DgeneratePom=true

#Tomcat port no
server.port=8091

#oracle db settings
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username=system
spring.datasource.password=Password123
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

the design for this JDBC program:

1. Service Layer
	EmployeeService (interface) only methods
	EmployeeServiceImpl - method definitions

2. DB Layer
        EmployeeDAO (interface) - only method names
        EmployeeDAOImpl  - method defintions
		 insertEmployee(Employee obj)
		{
		sql="INSERT INTO EMPLOYE....."
                using jdbTemplate object, i can call methods / APIs available to do the actual DB operations
                jdbcTemplate.save(obj);
             
         	}

3. Create main class main method
	From here,
	Autowire the Service class
        From service class, connect and call the dao methods
	I will call service method that will in turn call dao methods in turn does the DB operations

Employee.java:

package com.ofss;

public class Employee {
	String firstName;
	String lastName;
	long phoneNumber;
	String emailId;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String firstName, String lastName, long phoneNumber, String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
}

EmployeeDao.java

import java.util.List;


public interface EmployeeDao {
	void insertEmployee(Employee cus);
	void insertEmployees(List<Employee> employees);
	List<Employee> getAllEmployees();
	Employee getEmployeeByName(String empName);
	boolean deleteEmployeeByName(String empName);
}

EmployeeDaoImpl.java

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao{
	
	@Autowired 
	DataSource dataSource;

	// call back method
	@PostConstruct
	private void initialize(){
		System.out.println("Now, setting the data source in initialize method");
		setDataSource(dataSource);
	}

	
	@Override
	public void insertEmployee(Employee emp) {
		
		String sql = "INSERT INTO employee VALUES (?, ?, ?, ?)" ; // ? is a place holder
		getJdbcTemplate().update(sql, emp.getFirstName(),emp.getLastName(),emp.getPhoneNumber(), emp.getEmailId());
		System.out.println("Done inserting");
	}

	@Override
	public void insertEmployees(List<Employee> employees) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeByName(String empName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean deleteEmployeeByName(String empName) {
		String sql = "DELETE FROM employee WHERE FIRSTNAME='"+empName+"'" ; // ? is a place holder
		System.out.println("Going to fire this SQL NOW: "+sql);
		System.out.println("Currently in deleteEmployeeByName dao method");
		if (getJdbcTemplate().update(sql) > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}

Interface:
EmployeeService.java

import java.util.List;

public interface EmployeeService {
	void insertEmployee(Employee emp);
	void insertEmployees(List<Employee> employees);
	void getAllEmployees();
	void getEmployeeByName(String empName);
	public String deleteEmployeeByName(String empName);
}

EmployeeServiceImpl.java

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDaoImpl employeeDao;
	
	@Override
	public void insertEmployee(Employee emp) {
		// this needs to call the EmployeeDAO's insertEmployee() method
		employeeDao.insertEmployee(emp);
	}

	@Override
	public void insertEmployees(List<Employee> employees) {
		// TODO Auto-generated method stub
	}

	@Override
	public void getAllEmployees() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public String deleteEmployeeByName(String empName) {
		boolean isSuccess=employeeDao.deleteEmployeeByName(empName);
		if (isSuccess)
			return empName+" has been successfully deleted from the table";
		else
			return "no such employee found "+empName;
	}

	@Override
	public void getEmployeeByName(String empName) {
		// TODO Auto-generated method stub
	}
}

JDBCApplication.java

package com.sg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JDBCApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(JDBCApplication.class, args);
		EmployeeService es=context.getBean(EmployeeService.class);
		Employee e1=new Employee("Guru", "Murthy", 92929292, "guru@oracle.com");
		es.insertEmployee(e1);

	}

}


pom.xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.2.5.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.sg</groupId>
	<artifactId>SpringBoot-JDBC1</artifactId>
	<version>2</version>
	<name>SpringBoot-JDBC1</name>
	<description>Demo project for Spring Boot</description>

	<properties>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jdbc</artifactId>
		</dependency>

		<dependency>
			<groupId>com.oracle</groupId>
			<artifactId>oracle</artifactId>
			<version>11.2.0.2.0</version>
			<scope>runtime</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>


Be back at: 3.55 pm

Spring Boot - JPA:

Java Persistence API

1 JPA is just a specification
2 Whoever follows this, they must provide the imlementation
   Hibernate
   iBatis
   myBatis
   EclipseLink

Advantages:

1. It provides ORM concept
Object Relational Mapping

In ORM:

Map DB tables to Java classes
Map columns to Java class properties
Map SQL data types to Java data types
One row from the table represents exactly one object of this class

Advantage:

1. Less number of lines of code
2. Increasing the developer's productivity
3. * DB portablity
4. No need to write native SQL queries here (generally) - not considering special cases and complex queries
5. Developers would deal with Java objects, not with DB tables
	The moment you update Java object, you can see that corresponding row will get updated too & vice-versa
6. Spring JPA, provides the basic CRUD operations, that you can use READILY (0 coding)

Example:
	UPDATE EMPLOYEE SET SALARY=10000 WHERE EMPID > 1000; - will affect some records

In JPA:
	We have a bunch of Java objects created out of these DB table rows

	"e1"
	e1.setSalary(10000);

There is a "sync" between rows and the java objects
e1=null;

Of course, JPA also provides you to write SQL queries
JPA sits on top of JDBC which sits on top of SQL engine

SQL > JDBC > JPA

If your project is not DATA INTENSIVE, you can consider JPA

ORM tools such as Hibernate or iBatis, you get the API (methods) to do complex queries:

join tables
where clauses
sort
group by
parent - child table relationships

polygot 


Use Case:

You have 100 records in Employee table
You are requested to create 100 corresponding Java objects and add them to a List

List<Employee> allEmps;

JDBC:

while (rs.next())
{

	Employee e1=new Employee();
	e1.setName(rs.getString(1));
	e1.setLastName(rs.getString(2));
	...
	...
	allEmps.add(e1); 


}

You will get List<Employee) allEmps;

In JPA:

You will write zero code (Spring JPA) - not applicable to general JPA

embedded DB:

Apache Derby
PointBase
HSQL (Hypersonic SQL)

---

@Entity
class Employee
{
	@EmbeddedId
	MyEmployee me;
	Address adress;

}

class MyEmployee
{
	int empId;
	String empName;

}


@Entity
class Address
{
	int flatNo;
	String streetName;
	String city;
}


In pom.xml, you need to add the following dependencies:

1. spring-boot-starter-data-jpa 
2. db related dependencies: oracle, mysql....













