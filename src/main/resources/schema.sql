create database sysopsdb;

use sysopsdb;

CREATE TABLE region (
                        region_id INT NOT NULL AUTO_INCREMENT,
                        region_name VARCHAR(255) NOT NULL,
                        PRIMARY KEY (region_id)
);

CREATE TABLE vpc (
                     vpc_id INT NOT NULL AUTO_INCREMENT,
                     vpc_name VARCHAR(255) NOT NULL,
                     region_id INT NOT NULL,
                     PRIMARY KEY (vpc_id),
                     FOREIGN KEY (region_id) REFERENCES region(region_id)
);

CREATE TABLE azone(
                      az_id INT NOT NULL AUTO_INCREMENT,
                      az_name VARCHAR(255) NOT NULL,
                      region_id INT NOT NULL,
                      PRIMARY KEY (az_id),
                      FOREIGN KEY (region_id) REFERENCES region(region_id)
);

CREATE TABLE subnet (
                        subnet_id INT NOT NULL AUTO_INCREMENT,
                        subnet_name VARCHAR(255) NOT NULL,
                        vpc_id INT NOT NULL,
                        az_id INT NOT NULL,
                        PRIMARY KEY (subnet_id),
                        FOREIGN KEY (vpc_id) REFERENCES vpc(vpc_id),
                        FOREIGN KEY (az_id) REFERENCES azone(az_id)
);

CREATE TABLE ec2 (
                     ec2_id INT NOT NULL AUTO_INCREMENT,
                     ec2_name VARCHAR(255) NOT NULL,
                     subnet_id INT NOT NULL,
                     PRIMARY KEY (ec2_id),
                     FOREIGN KEY (subnet_id) REFERENCES subnet(subnet_id)
);

-- Insert Queries

INSERT INTO sysopsdb.region (region_name) VALUES ('us-west-2'), ('us-west-1'), ('us-east-1');

INSERT INTO sysopsdb.azone (az_name, region_id) VALUES ('us-west-2a', 1), ('us-west-2b', 1), ('us-west-1a', 2), ('us-west-1b', 2), ('us-east-1a', 3), ('us-east-1b', 3);

INSERT INTO sysopsdb.vpc (vpc_name, region_id) VALUES ('test-vpc-west-2', 1), ('test-vpc-west-1', 2), ('test-vpc-east-1', 3);

INSERT INTO sysopsdb.subnet (subnet_name, vpc_id, az_id) VALUES ('test-subnet-west-2a', 1, 1), ('test-subnet-west-2b', 1, 2), ('test-subnet-west-1a', 2, 3), ('test-subnet-west-1b', 2, 4), ('test-subnet-east-1a', 3, 5), ('test-subnet-east-1b', 3, 6);

INSERT INTO sysopsdb.ec2 (ec2_name, subnet_id) VALUES ('test-ec2-west-2a', 1), ('test-ec2-west-2b', 2), ('test-ec2-west-1a', 3), ('test-ec2-west-1b', 4), ('test-ec2-east-1a', 5), ('test-ec2-east-1b', 6);

SELECT * FROM sysopsdb.region;
SELECT * FROM SysOps_DB.azone;
SELECT * FROM sysopsdb.vpc;
SELECT * FROM sysopsdb.subnet;
SELECT * FROM sysopsdb.ec2;
