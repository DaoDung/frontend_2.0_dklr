<#if (Request)??>
<#include "init.ftl">
</#if>

<div class="row box MT10">
	<div class="col-sm-12 MT15" id="viewLsIndexSync">
		<button class="btn btn-active MB15 MR10" id="btn-indexing-applicant">Index applicant</button>
		<button class="btn btn-active MB15 MR10" id="btn-indexing-vehicletypecertificate">Index vehicletypecertificate</button>
		<button class="btn btn-active MB15 MR10" id="btn-indexing-cop">Index COP</button>
		<br>
	</div>
</div>

<script type="text/javascript">
	$("#btn-indexing-applicant").click(function (event) {
		console.log("index sync==================")
		$.ajax({
			url: "/o/dklr/indexing/applicant",
			dataType: "json",
			type: "POST",
			headers: {"groupId": ${groupId}},
			success: function (result) {
			},
			error : function (result) {
			}
		});
	});

	$("#btn-indexing-vehicletypecertificate").click(function (event) {
		console.log("index sync==================")
		$.ajax({
			url: "/o/dklr/indexing/vehicletypecertificate",
			dataType: "json",
			type: "POST",
			headers: {"groupId": ${groupId}},
			success: function (result) {
			},
			error : function (result) {
			}
		});
	});

	$("#btn-indexing-cop").click(function (event) {
		console.log("index sync==================")
		$.ajax({
			url: "/o/dklr/indexing/cop",
			dataType: "json",
			type: "POST",
			headers: {"groupId": ${groupId}},
			success: function (result) {
			},
			error : function (result) {
			}
		});
	});
</script>