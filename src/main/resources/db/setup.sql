create database inventorydb;
create user 'inventoryUser'@'localhost'identified by 'inventoryUser111';
grant all privileges on inventorydb.* to 'inventoryUser'@'localhost';
flush privileges;