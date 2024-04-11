create database if not exists `wx_robot`;

use wx_robot;

create table `msg_record`
(
    `id` bigint(20) not null primary key,
    `room_id` varchar(256),
    `room_name` varchar(128) not null,
    `person_id` varchar(128),
    `person_name` varchar(128) not null,
    `type` varchar(64) not null,
    `content_or_url` text not null,
    `time` bigint(20) not null
);
create index `idx_time` ON `msg_record`(`time`);
create index `idx_room_name` ON `msg_record`(`room_name`);

create table `scheduler` (
    `id` bigint(20) not null primary key,
    `room_id` varchar(256),
    `method` integer,
    `extend_info` varchar(256)
);

create table `wx_group` (
    `id` varchar(512) not null primary key,
    `room_name` varchar(128) not null
);