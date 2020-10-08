create table opencps_notificationqueue (
	notificationQueueId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	notificationType VARCHAR(75) null,
	className VARCHAR(75) null,
	classPK VARCHAR(75) null,
	payload VARCHAR(75) null,
	fromUsername VARCHAR(75) null,
	toUsername VARCHAR(75) null,
	toUserId LONG,
	toEmail VARCHAR(75) null,
	toTelNo VARCHAR(75) null,
	publicationDate DATE null,
	expireDate DATE null
);

create table opencps_notificationtemplate (
	notificationTemplateId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	notificationType VARCHAR(75) null,
	emailSubject VARCHAR(75) null,
	emailBody VARCHAR(75) null,
	textMessage VARCHAR(75) null,
	sendSMS BOOLEAN,
	sendEmail BOOLEAN,
	expireDuration INTEGER,
	userUrlPattern VARCHAR(75) null,
	guestUrlPattern VARCHAR(75) null,
	interval_ VARCHAR(75) null,
	grouping BOOLEAN
);

create table opencps_serverconfig (
	serverConfigId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	serverNo VARCHAR(75) null,
	serverName VARCHAR(75) null,
	protocol VARCHAR(75) null,
	configs VARCHAR(75) null,
	lastSync DATE null
);