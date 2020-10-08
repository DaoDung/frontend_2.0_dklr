<#if (Request)??>
<#include "init.ftl">
	
</#if>
<div id="contentMain" class="row panel M0" style="border: none;box-shadow: none">
	<div style="width: 100%;" id="manHinhDanhSach">
		<div class="panel-heading P0">
			<div class="row PL15 PR15">
				<div class="row-header align-middle-lg" style="justify-content: space-between;align-items: center;line-height: 32px;">
					<div>
						<div class="background-triangle-big">
							<i class="fa fa-file-text"></i>
						</div>
						<span class="text-bold" id="statusName" style="text-transform:uppercase;">Danh sách ấn chỉ đã cấp phát</span> &nbsp;&nbsp;&nbsp;
						<#if registration?has_content>
							
						<#else>
							<span class="text-bold red" style="text-transform:uppercase;"></span>
						</#if>
					</div>
					<div>
						<a class="PL5 PR5 hover-pointer no-icon" href="#searchAdvancedCollapse1" data-toggle="collapse">Nâng cao</a>

						<span id="fullScreen" onclick="fullScreen()">
							<i class="fa fa-expand fs20 toggle-collapse MR10 ML10" aria-hidden="true"></i>
							<i class="fa fa-compress fs20 MR10 ML10" aria-hidden="true" style="display: none"></i>
						</span>
					</div>
				</div>
			</div>
            <div class="" style="width:100%;margin-left: -15px;margin-right: -15px;padding-top: 5px;">
				<div class="" style="width:100%;padding-left:15px;">
                    <div class="filter-group">
                        <label for="vehicleclassFilter">Đối tượng</label>
						<select class="form-control" id="vehicleclassFilter" onchange="changeDoiTuong()">
							<option value="">Tất cả</option>
						</select>
                    </div>
                    <div class="filter-group">
                        <label for="stampIssueNoFilter">Số hồ sơ</label>
                        <input class="form-control" id="stampIssueNoFilter" >
                    </div>
					
                    <div class="filter-group">
                        <label for="stampShortNoFilter">Tên số ấn chỉ</label>
                        <input type="text" class="form-control" id="stampShortNoFilter" >
                    </div>
                    <div class="filter-group">
                        <label for="serialNoFilter">Số ấn chỉ</label>
                        <input type="text" class="form-control" id="serialNoFilter" >
                    </div>
                    <div class="filter-group">
                        <label for="appliedyear">Năm</label>
                        <input type="text" class="form-control" id="appliedyear" >
                    </div>
                    <div class="filter-group">
                        <label for="applieddatefrom">Ngày nộp(từ)</label>
                        <input type="date" class="form-control" id="applieddatefrom" >
                    </div>  
                    <div class="filter-group">
                        <label for="applieddateto">Ngày nộp(đến)</label>
                        <input type="date" class="form-control" id="applieddateto" >
                    </div>
                    <div class="filter-group">
                        <label for="usedFilter">Tình trạng</label>
						<select class="form-control" id="usedFilter">
							<option value=""></option>
							<option value="true">Đã sử dụng hết</option>
							<option value="false">Chưa sử dụng hết</option>
						</select>
                    </div>              	
				</div>
                <div style="width:100%;margin-left:15px;display:flex;justify-content: center">
                    <button type="button" onclick="search()" class="btn btn-active">Tìm kiếm</button>
                    <button type="button" onclick="xuatExcel()" class="btn btn-active">Xuất Excel</button>
                </div>
			</div>
            
		</div>
		<#--	-->
		<div id="wrapMain" class="table-responsive">
			<table class="table table-bordered M0">
				<#-- Table header -->
				<thead>
					<tr>
						<th class="text-center hover-pointer">
							<strong>STT</strong>
						</th>
						<th class="fieldDossier text-center hover-pointer" sort="serviceName" sort-type="desc">
							<strong>Đối tượng</strong>

						</th>
						<th class="fieldDossier text-center hover-pointer" sort="serviceName" sort-type="desc">
							<strong>Số hồ sơ</strong>

						</th>
						<th class="fieldDossier text-center hover-pointer" sort="serviceName" sort-type="desc">
							<strong>Ngày nộp</strong>

						</th>
						<th class="fieldDossier text-center hover-pointer" sort="serviceName" sort-type="desc">
							<strong>Tên sổ</strong>

						</th>
						<th class="fieldDossier text-center hover-pointer PL0 PR5" sort="dossierId" sort-type="desc">
							<strong>Số ấn chỉ </strong>
						</th>
						<th class="fieldDossier text-center hover-pointer" sort="submitDate" sort-type="desc">
							<strong>Năm cấp phát</strong>
						</th>
						<th class="text-center hover-pointer">
                            <strong>Trạng thái</strong>
						</th>
						<th class="text-center hover-pointer">
							<strong></strong>
						</th>
					</tr>
				</thead>
				<#-- Table body -->
				<tbody class="" id="danhSach">

				</tbody>
			</table>

		</div>
		<div class="row-header col-sm-12 PT20 PR0" style="background: #f6f6f6">
			<div class="clearfix align-middle" style="float: right">
				<span class="text-light-gray MR15"><i>Tổng số <span id="total" class="red"></span> kết quả được tìm thấy</i></span>
				<span class="show-per-page MT0">Hiển thị
					<span class="select-wrapper">
						<select class="ML5" id="listPage" onchange="changePageSize()" style="background-color: #ffffff">

						</select>
					</span>
				</span>
				<span id="btn-page" class="M0 P0" style="background: #ffffff"></span>
			</div>	
		</div>
	</div>
</div>
<script>
	console.log('manageDossier:',manageDossier)
	document.body.scrollTop = 0;
	document.documentElement.scrollTop = 0;
	document.getElementById("danhSachAnChiCapPhat").style.background= "linear-gradient(to right, #ffeaa0 0%,rgba(246,246,246,0) 100%)"
	document.getElementById("danhSachXeXuatXuong").style.background= "#fff0"
	document.getElementById("danhSachXeChoInPhieuXuatXuong").style.background= "#fff0"
	var originUrl = window.location.href.substr(0, window.location.href.lastIndexOf('/group'))
	var	groupId = window.themeDisplay.getScopeGroupId()
	var total = 0
	var pagesize = 10
	var page = 1
	var pageMax = Math.ceil(total/pagesize)
	function fullScreen(){
		$("#fullScreen").children().toggle();
		$("#panel_list").toggle();
		$("#mainType2").toggleClass("col-sm-10","col-sm-12");

	}
	function getList(){
		let applieddatefrom = document.getElementById("applieddatefrom").value
		const [year, month, day] = applieddatefrom.split('-')
		let applieddatefromFormat = ''
		if(typeof day !== 'undefined'){
			applieddatefromFormat = day + '/' + month + '/' + year
		}
		let applieddateto = document.getElementById("applieddateto").value
		const [year2, month2, day2] = applieddateto.split('-')
		let applieddatetoFormat = ''
		if(typeof day2 !== 'undefined'){
			applieddatetoFormat = day2 + '/' + month2 + '/' + year2
		}
		let params = {
			vehicleclass: document.getElementById("vehicleclassFilter").value,
			stampissueno: document.getElementById("stampIssueNoFilter").value,
			stampserialno: document.getElementById("serialNoFilter").value,
			stampshortno: document.getElementById("stampShortNoFilter").value,
			used: document.getElementById("usedFilter").value,
			appliedyear: document.getElementById("appliedyear").value,
			applieddatefrom: applieddatefromFormat,
			applieddateto: applieddatetoFormat,
			applicantprofileid: window.applicantprofileid
		}
		let Url = originUrl + '/o/rest/vr-app/issue/stampbook/search?'
		for (const key in params) {
			if (params[key] !== '') {
				Url += '&' + key + '=' + params[key]
			}
		}
	
		$.ajax({
			url: Url,
			type: "GET",
			success: function (success) {
				let html = '';
				for(let i=0; i< success.data.length; i++){
					html += `<tr class="rowTable">
							<td class="text-center">`+ (page*pagesize-pagesize+i+1) +`</td>
							<td class="text-center">`+ success.data[i].vehicleclass + `</td>
							<td class="text-center">`+ success.data[i].stampissueno + `</td>
							<td class="text-center">`+ success.data[i].applieddate + `</td>
							<td class="text-center">`+ success.data[i].stampshortno + `từ ` + success.data[i].serialstartno + `đến `+ success.data[i].serialendno +`</td>
							<td class="text-center">`+ success.data[i].stampserialno + `</td>
							<td class="text-center">`+ success.data[i].applieddate + `</td>
							<td class="text-center">`+ success.data[i].stampstatus + `</td>
							<td class="text-center" style="color: #0b72ba; font-weight: bold;" onclick="xemChiTiet(`+ success.data[i].outputsheetdetailid +`)"><span>Xem</span></td>
							</tr>`
				}
				document.getElementById("danhSach").innerHTML = html
				total = success.total
				pageMax =  Math.ceil(total/pagesize)
				document.getElementById("total").innerHTML = total
				document.querySelector("#listPage").innerHTML = ''
				for(let i=10; i<=total; i+=10){
					let option = document.createElement("option");
					option.text = i;
					option.value = i;
					document.querySelector("#listPage").appendChild(option);
				}
				document.getElementById('listPage').value = pagesize
				document.getElementById("btn-page").innerHTML = `
					<ul class="k-pager-numbers k-reset">
						<li onclick="lastPageLast()"><a class="k-link" style="border-radius: 0px; border-color: rgb(221, 221, 221); height: 27px; margin-right: 0px;"><span class="k-icon k-i-arrow-w"></span></a></li>
						<li onclick="lastPage()"><a class="k-link" style="border-radius: 0px; border-color: rgb(221, 221, 221); height: 27px; margin-right: 0px;">...</a></li>
						<li><span class="k-state-selected" style="height: 27px;">`+page+`</span></li>
						<li onclick="nextPage()"><a class="k-link" style="border-radius: 0px; border-color: rgb(221, 221, 221); height: 27px; margin-right: 0px;">...</a></li>
						<li onclick="nextPageLast()"><a class="k-link" style="border-radius: 0px; border-color: rgb(221, 221, 221); height: 27px; margin-right: 0px;"><span class="k-icon k-i-arrow-e"></span></li>
					</ul>
				`
			},
		});
	}
	function lastPageLast() {
		if(page > 1){
			page = 1
			getList()
		}
	}
	function lastPage() {
		if(page > 1 ){
			page -= 1
			getList()
		}
	}
	function nextPage() {
		if(page !== pageMax){
			page += 1
			getList()
		}
	}
	function nextPageLast() {
		if(page < pageMax){
			page = pageMax
			getList()
		}
		
	}
	function changePageSize() {
		var x = document.getElementById("listPage").value;
		pagesize =  x
		getList()
	}
	function search() {
		getList()
	}
	function getDictGroups(){
		$.ajax({
			url: originUrl + '/o/rest/v2/dictcollections/VR84/dictgroups',
			type: "GET",
			headers: {
				groupId: groupId,
				Accept: 'application/json'
			},
			success: function(success) {
				console.log('success',success)
				console.log('success',success.data)
				dictGroups = success.data
				let select = document.getElementById("vehicleclassFilter");
				dictGroups.forEach(function(item){
					let option = document.createElement("option");
					option.text = item.groupCode;
					option.value = item.dictGroupId;
					select.appendChild(option);
				})
			},
		})
	}
	function changeDoiTuong() {
		let value = document.getElementById("vehicleclassFilter").value;
		console.log(value)
	}
	function getApplicantsProfileID (applicantIdNo) {
		let Url = originUrl + '/o/rest/vr-app/applicant/profile/'+applicantIdNo
		$.ajax({
			url: Url,
			headers: {
				Accept: 'application/json'
			},
			type: "GET",
			success: function (success) {
				console.log('getApplicantsProfileID')
				window.applicantprofileid = success.id
				getList()
			},
		});
	}
	function getApplicants () {
		let Url = originUrl + '/o/rest/v2/applicants/selfdetail'
		$.ajax({
			url: Url,
			headers: {
				Accept: 'application/json'
			},
			type: "GET",
			success: function (success) {
				console.log('getApplicants')
				if(success.applicantIdType === 'business'){
					getApplicantsProfileID(success.applicantIdNo)
				}
			},
		});
	}
	function xuatExcel () {
		let applieddatefrom = document.getElementById("applieddatefrom").value
		const [year, month, day] = applieddatefrom.split('-')
		let applieddatefromFormat = ''
		if(typeof day !== 'undefined'){
			applieddatefromFormat = day + '/' + month + '/' + year
		}
		let applieddateto = document.getElementById("applieddateto").value
		const [year2, month2, day2] = applieddateto.split('-')
		let applieddatetoFormat = ''
		if(typeof day2 !== 'undefined'){
			applieddatetoFormat = day2 + '/' + month2 + '/' + year2
		}
		let params = {
			vehicleclass: document.getElementById("vehicleclassFilter").value,
			stampissueno: document.getElementById("stampIssueNoFilter").value,
			stampserialno: document.getElementById("serialNoFilter").value,
			stampshortno: document.getElementById("stampShortNoFilter").value,
			used: document.getElementById("usedFilter").value,
			appliedyear: document.getElementById("appliedyear").value,
			applieddatefrom: applieddatefromFormat,
			applieddateto: applieddatetoFormat,
			applicantprofileid: window.applicantprofileid
		}
		let Url = originUrl + '/o/rest/vr-app/issue/stampbook/export?'
		for (const key in params) {
			if (params[key] !== '') {
				Url += '&' + key + '=' + params[key]
			}
		}
		let data = {
			headercodes: '{auto},vehicleclass,stampissueno,applieddate,,{stampshortno} từ {serialstartno} đến {serialendno},applieddate,stampstatus',
			headerlabels: 'STT, Đối tượng, Số hồ sơ, Ngày nộp, Tên sổ, Số ân chỉ, Năm cấp phát, Trạng thái'
		}
		let dataPost = new URLSearchParams()
		for(key in data){
			dataPost.append(key, data[key])
		}
		axios.post(Url, dataPost, {
			header: {
				'Content-Type': 'application/x-www-form-urlencoded',
				'Accept': '*'
			},
			responseType: 'blob'
		}).then((req) => {
			const url = window.URL.createObjectURL(req.data);
            const link = document.createElement('a');
            link.href = url;
            link.setAttribute('download', 'Danh sách ấn chỉ đã cấp phát.xls'); //or any other extension
			console.log('url:',url)
			console.log(link)
            document.body.appendChild(link);
            link.click();
		})
	}
	getApplicants()
	getDictGroups()
	var table =  $('#danhSach')
	function xemChiTiet (outputsheetdetailid) {
		window.outputsheetdetailid= outputsheetdetailid
		manageDossier.navigate("/chi-tiet-an-chi-cap-phat")
	}
	$.ajax({
			url: originUrl + '/o/rest/vr-app/vehicle/record/count',
			type: "GET",
			success : function(result){
				console.log('aaaaaa:', document.getElementById("countDSXeDaXuatXuong"))
				document.getElementById("countDSXeDaXuatXuong").innerHTML = result
			},
		})
	$.ajax({
		url: originUrl + '/o/rest/vr-app/issue/stampbook/count',
		type: "GET",
		success : function(result){
			$("#countDSAnChiDaCapPhat").html(result);
		},
	})
</script>
<style>
    .filter-group{
        width: 33%;
        padding: 1px 10px;
        display: inline-block;
    }
	.filter-group label{
		display: inline-block!important;
		width: 30%!important;
	}
	.filter-group input,select{
		display: inline-block!important;
		width: 65%!important;
		height: 29px!important;
		font-size: 13px!important;
	}
    .btn-filter{
        color: #fff;
        background-color: #007bff;
        border-color: #007bff;
        font-weight: 400;
        text-align: center;
        font-size: 13px;
        margin: 5px 0px;
    }
	.btn-active{
		margin:5px;
	}
	.form-control{
		padding: 0px 10px!important;
	}
</style>
