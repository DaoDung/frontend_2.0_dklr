create index IX_E7D9C8D2 on opencps_notificationtemplate (emailSubject[$COLUMN_LENGTH:75$]);
create index IX_643C0A75 on opencps_notificationtemplate (groupId, notificationType[$COLUMN_LENGTH:75$]);

create index IX_51758EA8 on opencps_serverconfig (groupId, protocol[$COLUMN_LENGTH:75$]);
create index IX_14749CB0 on opencps_serverconfig (serverName[$COLUMN_LENGTH:75$]);
create index IX_97108B26 on opencps_serverconfig (serverNo[$COLUMN_LENGTH:75$]);