create index IX_67DF294D on dm_dataitem (dataGroupId, level);

create index IX_9545DA63 on vr_condition (filterModuleCode[$COLUMN_LENGTH:75$]);
create index IX_78070562 on vr_condition (specificationCode[$COLUMN_LENGTH:75$]);