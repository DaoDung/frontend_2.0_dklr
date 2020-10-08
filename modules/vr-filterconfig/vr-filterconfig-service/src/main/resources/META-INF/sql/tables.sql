create table dm_dataitem (
	id LONG not null primary key,
	dataGroupId LONG,
	code_0 VARCHAR(75) null,
	code_1 VARCHAR(75) null,
	code_2 VARCHAR(75) null,
	code_3 VARCHAR(75) null,
	level INTEGER,
	name VARCHAR(75) null,
	altername VARCHAR(75) null,
	description VARCHAR(75) null,
	validatedFrom DATE null,
	validatedTo DATE null,
	status INTEGER,
	synchDate DATE null
);

create table vr_condition (
	id LONG not null primary key,
	filterModuleCode VARCHAR(75) null,
	filterTableField VARCHAR(75) null,
	filterTableName VARCHAR(75) null,
	specificationCode VARCHAR(75) null,
	specificationDisplayName VARCHAR(75) null,
	specificationDataCollectionID VARCHAR(75) null,
	sequenceNo LONG,
	specificationBasicUnit VARCHAR(75) null,
	specificationStandard VARCHAR(75) null,
	specificationGroup VARCHAR(75) null,
	modifyDate DATE null,
	syncDate DATE null
);