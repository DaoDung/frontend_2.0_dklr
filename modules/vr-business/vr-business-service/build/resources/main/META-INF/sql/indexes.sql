create index IX_292E6FC5 on opencps_dossier (groupId, companyId, govAgencyCode[$COLUMN_LENGTH:75$], serviceCode[$COLUMN_LENGTH:75$], dossierTemplateNo[$COLUMN_LENGTH:75$], dossierStatus[$COLUMN_LENGTH:75$]);
create index IX_D4ACCBFA on opencps_dossier (groupId, dossierId);
create index IX_A09BF1BA on opencps_dossier (groupId, dossierTemplateNo[$COLUMN_LENGTH:75$]);
create index IX_13B226B5 on opencps_dossier (groupId, referenceUid[$COLUMN_LENGTH:75$]);
create index IX_C8644976 on opencps_dossier (groupId, serviceCode[$COLUMN_LENGTH:75$]);
create index IX_9A7DEA36 on opencps_dossier (groupId, userId);
create index IX_C4AA04E2 on opencps_dossier (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9525BE4 on opencps_dossier (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_65A9A912 on opencps_dossierfile (deliverableCode[$COLUMN_LENGTH:75$]);
create index IX_54A1F868 on opencps_dossierfile (dossierFileId);
create index IX_32059C0D on opencps_dossierfile (dossierId, dossierPartNo[$COLUMN_LENGTH:75$], removed);
create index IX_A0D470F4 on opencps_dossierfile (dossierId, dossierPartType, removed);
create index IX_967E0D40 on opencps_dossierfile (dossierId, fileTemplateNo[$COLUMN_LENGTH:75$], dossierPartType, fileEntryId, removed);
create index IX_7FA1EF5F on opencps_dossierfile (dossierId, fileTemplateNo[$COLUMN_LENGTH:75$], dossierPartType, removed);
create index IX_ECAF32F9 on opencps_dossierfile (dossierId, fileTemplateNo[$COLUMN_LENGTH:75$], removed);
create index IX_4C1D4556 on opencps_dossierfile (dossierId, isNew, removed);
create index IX_AEEE542B on opencps_dossierfile (dossierId, referenceUid[$COLUMN_LENGTH:75$], removed);
create index IX_72D2A0C4 on opencps_dossierfile (dossierId, removed);
create index IX_C7669357 on opencps_dossierfile (fileEntryId);
create index IX_6C6A28B9 on opencps_dossierfile (groupId, referenceUid[$COLUMN_LENGTH:75$]);
create index IX_E3E31523 on opencps_dossierfile (referenceUid[$COLUMN_LENGTH:75$]);
create index IX_F3B1D05E on opencps_dossierfile (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_558ED660 on opencps_dossierfile (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_E4E0E58C on opencps_registration (applicantIdNo[$COLUMN_LENGTH:75$]);
create index IX_521D957E on opencps_registration (groupId, applicantIdNo[$COLUMN_LENGTH:75$], govAgencyCode[$COLUMN_LENGTH:75$], registrationState);
create index IX_79B0B784 on opencps_registration (groupId, applicantIdNo[$COLUMN_LENGTH:75$], markasdeleted);
create index IX_B5AC1550 on opencps_registration (groupId, registrationId);
create index IX_4E58ED22 on opencps_registration (groupId, submitting);
create index IX_F5277266 on opencps_registration (groupId, userId, registrationState);
create index IX_41C6165C on opencps_registration (groupId, userId, submitting);
create index IX_44278B36 on opencps_registration (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_41656738 on opencps_registration (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_CA603D28 on vr_actionconfig (actionCode[$COLUMN_LENGTH:75$], processNo[$COLUMN_LENGTH:75$]);

create index IX_4EB87313 on vr_applicantprofile (mtCore, applicantCity[$COLUMN_LENGTH:75$]);
create index IX_4F056F15 on vr_applicantprofile (mtCore, applicantCode[$COLUMN_LENGTH:75$]);
create index IX_AE10CCDC on vr_applicantprofile (mtCore, applicantRegion[$COLUMN_LENGTH:75$]);
create index IX_25D02E5A on vr_applicantprofile (mtCore, applicantStatus[$COLUMN_LENGTH:75$]);
create index IX_A0484331 on vr_applicantprofile (mtCore, mappingMA_CTY[$COLUMN_LENGTH:75$]);
create index IX_9F98B126 on vr_applicantprofile (mtCore, mappingStatus[$COLUMN_LENGTH:75$]);
create index IX_C1B07E56 on vr_applicantprofile (mtCore, mappingTEN_CTY[$COLUMN_LENGTH:75$]);

create index IX_A8FFD4D3 on vr_applicantprofilehistory (mtCore, applicantCity[$COLUMN_LENGTH:75$]);
create index IX_A94CD0D5 on vr_applicantprofilehistory (mtCore, applicantCode[$COLUMN_LENGTH:75$]);
create index IX_9406BE9C on vr_applicantprofilehistory (mtCore, applicantRegion[$COLUMN_LENGTH:75$]);
create index IX_BC6201A on vr_applicantprofilehistory (mtCore, applicantStatus[$COLUMN_LENGTH:75$]);
create index IX_FA8FA4F1 on vr_applicantprofilehistory (mtCore, mappingMA_CTY[$COLUMN_LENGTH:75$]);
create index IX_F9E012E6 on vr_applicantprofilehistory (mtCore, mappingStatus[$COLUMN_LENGTH:75$]);
create index IX_B0555496 on vr_applicantprofilehistory (mtCore, mappingTEN_CTY[$COLUMN_LENGTH:75$]);

create index IX_50E34E12 on vr_cfg_limit_technicalspec (vehicletype[$COLUMN_LENGTH:75$], markup_SMRM[$COLUMN_LENGTH:75$], searching_drive_config);

create index IX_A886F240 on vr_cfg_technicalspec (vehicleclass[$COLUMN_LENGTH:75$], Module[$COLUMN_LENGTH:75$]);
create index IX_E4B552F2 on vr_cfg_technicalspec (vehicleclass[$COLUMN_LENGTH:75$], spec_category[$COLUMN_LENGTH:75$], Module[$COLUMN_LENGTH:75$]);
create index IX_8BA0F99C on vr_cfg_technicalspec (vehicleclass[$COLUMN_LENGTH:75$], vehicletype[$COLUMN_LENGTH:75$], spec_category[$COLUMN_LENGTH:75$], Module[$COLUMN_LENGTH:75$]);

create index IX_E60D5A8E on vr_clearingstampbook (mtCore, certificateId);
create index IX_14AFECBC on vr_clearingstampbook (mtCore, certificateNumber[$COLUMN_LENGTH:75$]);
create index IX_CE4C1AF5 on vr_clearingstampbook (mtCore, debitNoteId);
create index IX_326198DD on vr_clearingstampbook (mtCore, inputSheetId, bookId, stampType[$COLUMN_LENGTH:75$]);
create index IX_4FE9D640 on vr_clearingstampbook (mtCore, outputSheetId, bookId, stampType[$COLUMN_LENGTH:75$]);

create index IX_25D6DEF1 on vr_copproductionplantemployee (dossierId);
create index IX_26C0D5CA on vr_copproductionplantemployee (mtCore, copReportNo[$COLUMN_LENGTH:75$]);
create index IX_6B40D82E on vr_copproductionplantemployee (mtCore, copReportRepositoryID);

create index IX_7C62DC13 on vr_copproductionplantequipment (dossierId);
create index IX_D694506C on vr_copproductionplantequipment (mtCore, copReportNo[$COLUMN_LENGTH:75$]);
create index IX_E53CF050 on vr_copproductionplantequipment (mtCore, copReportRepositoryID);

create index IX_B12F73AA on vr_copproductionplantprodequipment (dossierId);
create index IX_34B59743 on vr_copproductionplantprodequipment (mtCore, copReportNo[$COLUMN_LENGTH:75$]);
create index IX_6310D667 on vr_copproductionplantprodequipment (mtCore, copReportRepositoryID);

create index IX_3CB89068 on vr_copproducttype (dossierId);
create index IX_2E485E81 on vr_copproducttype (mtCore, copReportNo[$COLUMN_LENGTH:75$]);
create index IX_E47A2825 on vr_copproducttype (mtCore, copReportRepositoryID);

create index IX_102B1081 on vr_copreport_attach (dossierId);
create index IX_BEF0535A on vr_copreport_attach (mtCore, copReportNo[$COLUMN_LENGTH:75$]);
create index IX_409CA1BE on vr_copreport_attach (mtCore, copReportRepositoryID);

create index IX_A7ABEB51 on vr_copreportrepository (dossierId);
create index IX_E7D077BA on vr_copreportrepository (mtCore, applicantProfileId, productionPlantCode[$COLUMN_LENGTH:75$]);
create index IX_403A2E2E on vr_copreportrepository (mtCore, applicantProfileId, productionPlantName[$COLUMN_LENGTH:75$], productionPlantAddress[$COLUMN_LENGTH:75$]);
create index IX_B079EA2A on vr_copreportrepository (mtCore, copReportNo[$COLUMN_LENGTH:75$]);
create index IX_2293509B on vr_copreportrepository (mtCore, copReportStatus[$COLUMN_LENGTH:75$]);

create index IX_54C9F50A on vr_corporation_attendee (applicantIdNo[$COLUMN_LENGTH:75$], inspectionDate);
create index IX_44BAF401 on vr_corporation_attendee (corporationCode[$COLUMN_LENGTH:75$], inspectionDate);
create index IX_8F38B7B0 on vr_corporation_attendee (dossierId, activityCatetory[$COLUMN_LENGTH:75$]);
create index IX_5BB0D6B9 on vr_corporation_attendee (dossierId, assignType[$COLUMN_LENGTH:75$]);
create index IX_30221D28 on vr_corporation_attendee (leaderId, inspectionDate);
create index IX_232DDBD4 on vr_corporation_attendee (managerId, inspectionDate);

create index IX_4A27991A on vr_corporation_inspector (contactcode[$COLUMN_LENGTH:75$]);
create index IX_2996D9F0 on vr_corporation_inspector (corporationid[$COLUMN_LENGTH:75$]);
create index IX_5692401F on vr_corporation_inspector (inspectorid);
create index IX_894C5D6F on vr_corporation_inspector (teamid);

create index IX_AE6543F4 on vr_corporation_view (corporationid[$COLUMN_LENGTH:75$], inspectorid);
create index IX_1A07F035 on vr_corporation_view (corporationid[$COLUMN_LENGTH:75$], isleader);
create index IX_87438C5D on vr_corporation_view (inspectorid, corporationid[$COLUMN_LENGTH:75$], isleader);
create index IX_ABEFCE4C on vr_corporation_view (isleader);

create index IX_AA25305E on vr_history_profile (applicantCode[$COLUMN_LENGTH:75$]);
create index IX_A12E5E2 on vr_history_profile (contentType[$COLUMN_LENGTH:75$]);
create index IX_8028C655 on vr_history_profile (dossierId);
create index IX_A7B07EC on vr_history_profile (dossierIdCTN[$COLUMN_LENGTH:75$]);
create index IX_2159D8CE on vr_history_profile (productionPlantCode[$COLUMN_LENGTH:75$]);

create index IX_35B2235B on vr_inputsheet (mtCore, corporationId);
create index IX_85E673A2 on vr_inputsheet (mtCore, inputSheetNo[$COLUMN_LENGTH:75$]);
create index IX_B102FB1B on vr_inputsheet (mtCore, inputSheetType);

create index IX_6D93834C on vr_inputstampbook (mtCore, inputSheetId, bookId, stampType[$COLUMN_LENGTH:75$]);
create index IX_219FA807 on vr_inputstampbook (sum3);

create index IX_96FD5ED1 on vr_inputstampbookdetails (bookId, sequenceNo);
create index IX_6E020C25 on vr_inputstampbookdetails (mtCore, certificateId);
create index IX_4933FAD3 on vr_inputstampbookdetails (mtCore, certificateNumber[$COLUMN_LENGTH:75$]);
create index IX_F5ABCA16 on vr_inputstampbookdetails (mtCore, corporationId);
create index IX_DAB6E7D9 on vr_inputstampbookdetails (mtCore, dossierId);
create index IX_E05D11B9 on vr_inputstampbookdetails (mtCore, inputSheetId, bookId);
create index IX_87F799EB on vr_inputstampbookdetails (mtCore, vehicleRecordId);

create index IX_6E417EA2 on vr_inspectionstandard (deliverableCode[$COLUMN_LENGTH:75$]);
create index IX_16DBF1BC on vr_inspectionstandard (dossierid);
create index IX_C8D10622 on vr_inspectionstandard (vehicleCertificateId, markupstatus);

create index IX_E8DBD431 on vr_inventory (mtCore, bookId, vehicleClass[$COLUMN_LENGTH:75$]);
create index IX_239D7771 on vr_inventory (mtCore, checkStatus);
create index IX_3A84D3F9 on vr_inventory (mtCore, checkType);
create index IX_27112A51 on vr_inventory (mtCore, yearofPeriod, corporationId);
create index IX_79A029C2 on vr_inventory (mtCore, yearofPeriod, vehicleClass[$COLUMN_LENGTH:75$]);

create index IX_9F0FC661 on vr_issue (issueCorporationId, digitalissuestatus);
create index IX_E3402173 on vr_issue (mtCore, copreportno[$COLUMN_LENGTH:75$]);
create index IX_AB7D8BD on vr_issue (mtCore, corporationId[$COLUMN_LENGTH:75$]);
create index IX_C32D59B6 on vr_issue (mtCore, dossierId, applicantProfileId);
create index IX_1764BD94 on vr_issue (mtCore, issueCorporationId);
create index IX_756154E7 on vr_issue (mtCore, productionPlantId);
create index IX_AD9D84A1 on vr_issue (mtCore, stampIssueNo[$COLUMN_LENGTH:75$]);
create index IX_328C0104 on vr_issue (mtCore, verifyCorporationId[$COLUMN_LENGTH:75$]);

create index IX_BB3D7FAC on vr_issue_equipmentcertificate (applicantNo[$COLUMN_LENGTH:75$], vehiclecertificaterecordno[$COLUMN_LENGTH:75$]);
create index IX_C549F317 on vr_issue_equipmentcertificate (issueVehicleCertificateId);
create index IX_60ED1289 on vr_issue_equipmentcertificate (vehiclecertificaterecordno[$COLUMN_LENGTH:75$]);

create index IX_B138AAE0 on vr_issue_vehiclecertificate (mtCore, dossierId, certificateId);
create index IX_BF91BFB0 on vr_issue_vehiclecertificate (mtCore, issueId);

create index IX_ADDE70BB on vr_outputsheet (mtCore, dossierId);
create index IX_4C1252F4 on vr_outputsheet (mtCore, outputSheetNo[$COLUMN_LENGTH:75$]);
create index IX_9BB44DED on vr_outputsheet (mtCore, outputSheetType);
create index IX_FF5A4101 on vr_outputsheet (mtCore, purchaserCorporationId);
create index IX_5AE18B8C on vr_outputsheet (mtCore, supplierCorporationId);

create index IX_6294E39B on vr_outputsheetdetails (mtCore, certificateId);
create index IX_81022749 on vr_outputsheetdetails (mtCore, certificateNumber[$COLUMN_LENGTH:75$]);
create index IX_DB1FD8AA on vr_outputsheetdetails (mtCore, inputSheetId, bookId, stampType[$COLUMN_LENGTH:75$]);
create index IX_F68088 on vr_outputsheetdetails (mtCore, issueVehicleCertificateId);
create index IX_BEF39013 on vr_outputsheetdetails (mtCore, outputSheetId, bookId, stampType[$COLUMN_LENGTH:75$]);

create index IX_D5231717 on vr_productclassification (productionPlantCode[$COLUMN_LENGTH:75$]);

create index IX_97ED690B on vr_productionplant (applicantProfileId);
create index IX_F7333C70 on vr_productionplant (mtCore, applicantCode[$COLUMN_LENGTH:75$]);
create index IX_99303DD9 on vr_productionplant (mtCore, applicantProfileId, productionPlantAddress[$COLUMN_LENGTH:75$], productionPlantStatus[$COLUMN_LENGTH:75$]);
create index IX_37AE834A on vr_productionplant (mtCore, applicantProfileId, productionPlantCode[$COLUMN_LENGTH:75$], productionPlantStatus[$COLUMN_LENGTH:75$]);
create index IX_AA0E095E on vr_productionplant (mtCore, applicantProfileId, productionPlantName[$COLUMN_LENGTH:75$], productionPlantAddress[$COLUMN_LENGTH:75$]);
create index IX_D688846C on vr_productionplant (mtCore, applicantProfileId, productionPlantName[$COLUMN_LENGTH:75$], productionPlantStatus[$COLUMN_LENGTH:75$]);
create index IX_8A598430 on vr_productionplant (mtCore, applicantProfileId, productionPlantRepresentative[$COLUMN_LENGTH:75$], productionPlantAddress[$COLUMN_LENGTH:75$]);
create index IX_264DBBF1 on vr_productionplant (mtCore, applicantProfileId, registrationFormId);
create index IX_EDA6FD0D on vr_productionplant (mtCore, applicantProfileId, registrationId);
create index IX_CE5A4217 on vr_productionplant (mtCore, mappingMA_CTY[$COLUMN_LENGTH:75$], mappingMA_XUONG_LR[$COLUMN_LENGTH:75$]);
create index IX_47C67E81 on vr_productionplant (mtCore, mappingStatus[$COLUMN_LENGTH:75$]);
create index IX_B5C2E7E5 on vr_productionplant (mtCore, productionPlantStatus[$COLUMN_LENGTH:75$]);
create index IX_8C73D16D on vr_productionplant (mtCore, productionPlantType[$COLUMN_LENGTH:75$]);
create index IX_360605FA on vr_productionplant (productionPlantCode[$COLUMN_LENGTH:75$]);

create index IX_25619A8C on vr_productionplantemployee (productionPlantCode[$COLUMN_LENGTH:75$]);

create index IX_6517212A on vr_productionplantequipment (productionPlantCode[$COLUMN_LENGTH:75$]);

create index IX_D64BC778 on vr_productionplantequipmentmarkup (productionPlantEquipmentId);

create index IX_993B2901 on vr_productionplantprodequipment (productionPlantCode[$COLUMN_LENGTH:75$]);

create index IX_E0B48E84 on vr_productionplantsupplier (corporationCode[$COLUMN_LENGTH:75$]);
create index IX_1551E5AE on vr_productionplantsupplier (productionPlantCode[$COLUMN_LENGTH:75$]);

create index IX_3607894F on vr_producttype (productionPlantCode[$COLUMN_LENGTH:75$], productClassificationCode[$COLUMN_LENGTH:75$]);

create index IX_BDE0B212 on vr_report (reportCode[$COLUMN_LENGTH:75$]);

create index IX_C713A3BD on vr_rp_dossierstatistics (applicantNo[$COLUMN_LENGTH:75$]);
create index IX_4DBCA89D on vr_rp_dossierstatistics (corporationId[$COLUMN_LENGTH:75$]);
create index IX_490EFC81 on vr_rp_dossierstatistics (dossierIdCTN[$COLUMN_LENGTH:75$]);
create index IX_D9135CEB on vr_rp_dossierstatistics (dossierid, dossierIdCTN[$COLUMN_LENGTH:75$]);
create index IX_66A31CE6 on vr_rp_dossierstatistics (dossierno[$COLUMN_LENGTH:75$]);
create index IX_15B0727E on vr_rp_dossierstatistics (inspectorcode[$COLUMN_LENGTH:75$]);

create index IX_59D89DF7 on vr_technicalspec_lkxcg (convertassembleId);
create index IX_89783243 on vr_technicalspec_lkxcg (deliverableCode[$COLUMN_LENGTH:75$]);
create index IX_723DE117 on vr_technicalspec_lkxcg (dossierId, mtCore);
create index IX_C6353F04 on vr_technicalspec_lkxcg (dossierIdCTN[$COLUMN_LENGTH:75$]);
create index IX_FE89CA3D on vr_technicalspec_lkxcg (dossierNo[$COLUMN_LENGTH:75$], mtCore);
create index IX_9FDF8192 on vr_technicalspec_lkxcg (referenceUid[$COLUMN_LENGTH:75$]);

create index IX_B52FB9AF on vr_technicalspec_lkxmy (convertassembleId);
create index IX_50D2DBFB on vr_technicalspec_lkxmy (deliverableCode[$COLUMN_LENGTH:75$]);
create index IX_CD94FCCF on vr_technicalspec_lkxmy (dossierId, mtCore);
create index IX_1FD9B04C on vr_technicalspec_lkxmy (dossierIdCTN[$COLUMN_LENGTH:75$]);
create index IX_59E0E5F5 on vr_technicalspec_lkxmy (dossierNo[$COLUMN_LENGTH:75$], mtCore);
create index IX_F983F2DA on vr_technicalspec_lkxmy (referenceUid[$COLUMN_LENGTH:75$]);

create index IX_5307DFF8 on vr_technicalspec_xcg (convertassembleId);
create index IX_F5E20084 on vr_technicalspec_xcg (deliverableCode[$COLUMN_LENGTH:75$]);
create index IX_6B6D2318 on vr_technicalspec_xcg (dossierId, mtCore);
create index IX_B8930063 on vr_technicalspec_xcg (dossierIdCTN[$COLUMN_LENGTH:75$]);
create index IX_F7B90C3E on vr_technicalspec_xcg (dossierNo[$COLUMN_LENGTH:75$], mtCore);
create index IX_923D42F1 on vr_technicalspec_xcg (referenceUid[$COLUMN_LENGTH:75$]);

create index IX_A39EEF17 on vr_technicalspec_xchbb (convertassembleId);
create index IX_CE04B63 on vr_technicalspec_xchbb (deliverableCode[$COLUMN_LENGTH:75$]);
create index IX_BC043237 on vr_technicalspec_xchbb (dossierId, mtCore);
create index IX_EDC8B9E4 on vr_technicalspec_xchbb (dossierIdCTN[$COLUMN_LENGTH:75$]);
create index IX_48501B5D on vr_technicalspec_xchbb (dossierNo[$COLUMN_LENGTH:75$], mtCore);
create index IX_C772FC72 on vr_technicalspec_xchbb (referenceUid[$COLUMN_LENGTH:75$]);

create index IX_8BA84851 on vr_technicalspec_xcnbb (convertassembleId);
create index IX_3402AB1D on vr_technicalspec_xcnbb (deliverableCode[$COLUMN_LENGTH:75$]);
create index IX_A40D8B71 on vr_technicalspec_xcnbb (dossierId, mtCore);
create index IX_BFC7046A on vr_technicalspec_xcnbb (dossierIdCTN[$COLUMN_LENGTH:75$]);
create index IX_30597497 on vr_technicalspec_xcnbb (dossierNo[$COLUMN_LENGTH:75$], mtCore);
create index IX_997146F8 on vr_technicalspec_xcnbb (referenceUid[$COLUMN_LENGTH:75$]);

create index IX_9A8495C on vr_technicalspec_xdd (convertassembleId);
create index IX_4B9572E8 on vr_technicalspec_xdd (deliverableCode[$COLUMN_LENGTH:75$]);
create index IX_220D8C7C on vr_technicalspec_xdd (dossierId, mtCore);
create index IX_8B27487F on vr_technicalspec_xdd (dossierIdCTN[$COLUMN_LENGTH:75$]);
create index IX_AE5975A2 on vr_technicalspec_xdd (dossierNo[$COLUMN_LENGTH:75$], mtCore);
create index IX_64D18B0D on vr_technicalspec_xdd (referenceUid[$COLUMN_LENGTH:75$]);

create index IX_AE5EFBB0 on vr_technicalspec_xmy (convertassembleId);
create index IX_BD3CAA3C on vr_technicalspec_xmy (deliverableCode[$COLUMN_LENGTH:75$]);
create index IX_C6C43ED0 on vr_technicalspec_xmy (dossierId, mtCore);
create index IX_123771AB on vr_technicalspec_xmy (dossierIdCTN[$COLUMN_LENGTH:75$]);
create index IX_531027F6 on vr_technicalspec_xmy (dossierNo[$COLUMN_LENGTH:75$], mtCore);
create index IX_EBE1B439 on vr_technicalspec_xmy (referenceUid[$COLUMN_LENGTH:75$]);

create index IX_D5C1D02E on vr_templateno (patternNo[$COLUMN_LENGTH:75$], year);

create index IX_2E86821E on vr_trackchanges (applicantCode[$COLUMN_LENGTH:75$]);
create index IX_661DA7A2 on vr_trackchanges (contentType[$COLUMN_LENGTH:75$]);
create index IX_3EA06EAA on vr_trackchanges (dossierId, contentFileTemplate[$COLUMN_LENGTH:75$]);
create index IX_2B646CF3 on vr_trackchanges (dossierIdCTN[$COLUMN_LENGTH:75$], contentFileTemplate[$COLUMN_LENGTH:75$]);
create index IX_9E66DA8E on vr_trackchanges (productionPlantCode[$COLUMN_LENGTH:75$]);

create index IX_C4E04EB on vr_vehicleequipment (dossierid);
create index IX_4C8ACF05 on vr_vehicleequipment (vehicleCertificateId);

create index IX_DFDB442B on vr_vehiclerecord (mtCore, applicantProfileId, printingStatus);
create index IX_11DCB74F on vr_vehiclerecord (mtCore, applicantProfileId, vehicleRecordStatus);
create index IX_1060A6A8 on vr_vehiclerecord (mtCore, certificateId);
create index IX_CC353BDC on vr_vehiclerecord (mtCore, dossierId);
create index IX_40DD1815 on vr_vehiclerecord (mtCore, issueVehicleCertificateId);

create index IX_D910347C on vr_vehiclespecification (deliverableCode[$COLUMN_LENGTH:75$]);
create index IX_98F69316 on vr_vehiclespecification (dossierid);
create index IX_B90D0106 on vr_vehiclespecification (vehicleCertificateId, specificationCode[$COLUMN_LENGTH:75$]);

create index IX_26EB54B3 on vr_vehicletypecertificate (applicantIdNo[$COLUMN_LENGTH:75$], expiredStatus[$COLUMN_LENGTH:75$]);
create index IX_4877CDFB on vr_vehicletypecertificate (applicantIdNo[$COLUMN_LENGTH:75$], productionPlantCode[$COLUMN_LENGTH:75$]);
create index IX_7D3A8366 on vr_vehicletypecertificate (applicantIdNo[$COLUMN_LENGTH:75$], vehicleClass[$COLUMN_LENGTH:75$], expiredStatus[$COLUMN_LENGTH:75$], certificateRecordNo[$COLUMN_LENGTH:75$]);
create index IX_15BC9093 on vr_vehicletypecertificate (certificateRecordNo[$COLUMN_LENGTH:75$], serviceCode[$COLUMN_LENGTH:75$]);
create index IX_28354988 on vr_vehicletypecertificate (commonSafetyStandard[$COLUMN_LENGTH:75$]);
create index IX_5937DACF on vr_vehicletypecertificate (copReportNo[$COLUMN_LENGTH:75$]);
create index IX_731E4BE9 on vr_vehicletypecertificate (corporationId[$COLUMN_LENGTH:75$], inspectorId);
create index IX_3B744AE2 on vr_vehicletypecertificate (deliverableCode[$COLUMN_LENGTH:75$]);
create index IX_A101A504 on vr_vehicletypecertificate (designSymbol[$COLUMN_LENGTH:75$]);
create index IX_3591BB06 on vr_vehicletypecertificate (designerCode[$COLUMN_LENGTH:75$]);
create index IX_95964DF6 on vr_vehicletypecertificate (dossierId, mtCore);
create index IX_21E2371C on vr_vehicletypecertificate (dossierNo[$COLUMN_LENGTH:75$], mtCore);
create index IX_69E197F2 on vr_vehicletypecertificate (emissionStandard[$COLUMN_LENGTH:75$]);
create index IX_5CCF6105 on vr_vehicletypecertificate (expiredStatus[$COLUMN_LENGTH:75$], serviceCode[$COLUMN_LENGTH:75$]);
create index IX_3F8D9294 on vr_vehicletypecertificate (inspectionRecordNo[$COLUMN_LENGTH:75$]);
create index IX_4B46F48 on vr_vehicletypecertificate (inspectorId);
create index IX_41B4B7A6 on vr_vehicletypecertificate (manufacturerForeignCode[$COLUMN_LENGTH:75$]);
create index IX_C3379750 on vr_vehicletypecertificate (serviceCode[$COLUMN_LENGTH:75$], applicantIdNo[$COLUMN_LENGTH:75$], mtCore);
create index IX_DAA88BD3 on vr_vehicletypecertificate (serviceCode[$COLUMN_LENGTH:75$], applicantIdNo[$COLUMN_LENGTH:75$], productionPlantCode[$COLUMN_LENGTH:75$], mtCore);
create index IX_8404766D on vr_vehicletypecertificate (serviceCode[$COLUMN_LENGTH:75$], applicantIdNo[$COLUMN_LENGTH:75$], productionPlantName[$COLUMN_LENGTH:75$], productionPlantAddress[$COLUMN_LENGTH:75$]);
create index IX_9EA52299 on vr_vehicletypecertificate (vehicleClass[$COLUMN_LENGTH:75$], certifiedVehicleType[$COLUMN_LENGTH:75$], certifiedTrademarkName[$COLUMN_LENGTH:75$], certifiedCommercialName[$COLUMN_LENGTH:75$], certifiedModelCode[$COLUMN_LENGTH:75$], serviceCode[$COLUMN_LENGTH:75$]);
create index IX_CC880E73 on vr_vehicletypecertificate (verificationCertificateNo[$COLUMN_LENGTH:75$]);