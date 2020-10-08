<#if (Request)??>
<#include "init.ftl">
	
</#if>

<div id="contentMain" class="row panel M0" style="border: none;box-shadow: none">
		<div id="dialog"></div>
		<div id="dialog-cauhinh" oncontextmenu="return false;" style="width: 100%; z-index: 9999999999;background: #fff;position: fixed; top: 0; left: 0; display: none;">
			<div id="nav-filter" style="position: absolute;top: 64px;right: 0; width: 280px;height: 100%; background-color: #fff; box-shadow: -3px 6px 16px #888888;">
				<div style="width: 87%;padding: 10px;">
					<input id="input-label" style="width: 100%;height: 30px; border-radius: 5px;border: 1px solid;padding: 2px 10px;" type="" name="">

				</div>
				<hr>
				<div id="list-label" style="width: 100%; box-sizing: border-box;">
					
				</div>
			</div>
			<div style="width: 100%;">
				<div style="width: 100%;background: #2196f3;color: #fff; height: 64px; line-height: 64px; display: flex; justify-content: space-between; box-shadow: 0px 2px 4px -1px rgba(0,0,0,0.2), 0px 4px 5px 0px rgba(0,0,0,0.14), 0px 1px 10px 0px rgba(0,0,0,0.12); padding: 0 15px;">
					<div>
						<button id="btn-close-cauhinh" style="width: 36px; height: 36px; color: #fff; font-weight: bold; background: none; border: none; cursor: pointer;">X</button>
						<strong style="font-size: 25px; margin-left: 20px;font-family: 'Roboto', sans-serif;">Cấu hình phôi</strong>
					</div>
					
					<div style="padding-right: 61px;">
						<button class="btn btn-active" id="btn-save-cauhinh" style="height: 64px;color: #fff; font-weight: bold; background: none; border: none; cursor: pointer;margin:0 10px;">Lưu lại</button>
					</div>
				</div>
				<div style="width: 100%;height: 700px;overflow: auto;" >
					<div id="page" style="width: 21cm;min-height: 29.7cm;margin: 1cm auto;border: 1px #D3D3D3 solid;">
						<div id="printTraCuu" style="background-size: cover;height: 297mm;width: 210mm;margin-left: auto;margin-right: auto;position: relative;">
							
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="panel-heading P0">
			<div class="row PL15 PR15">
				<div class="row-header align-middle-lg" style="justify-content: space-between;align-items: center;line-height: 32px;">
					<div>
						<div class="background-triangle-big">
							<i class="fa fa-file-text"></i>
						</div>
						<span class="text-bold" id="statusName" style="text-transform:uppercase;">Danh sách xe chờ in phiếu xuất xưởng</span> &nbsp;&nbsp;&nbsp;
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
            <div class="" style="width:100%;padding-top: 5px;display: flex;">
                <div style="width: 82%;">
					<div style="display: flex;align-items: center;"><div class="triangle-right"></div><strong>Danh sách hồ sơ</strong></div>
					<div style="width: 100%;">
						<div class="filter-group" style="padding: 3px 0px; width: 24%;">
							<label for="vehicleclassFilter">Đối tượng</label>
							<select class="form-control" id="vehicleclassFilter">
								<option value="">Tất cả</option>
							</select>
						</div>
						<div class="filter-group" style="padding: 3px 0px; width: 24%;">
							<label for="issuetypeFilter">Loại Hồ sơ</label>
							<input type="text" class="form-control" id="issuetypeFilter" >
						</div>
					</div>
					<div style="width: 100%;overflow: scroll;">
						<table class="table-hoso-filter">
							<thead>
								<tr>
									<th><strong>Chọn</strong></th>
									<th><strong>Số hồ sơ</strong></th>
									<th><strong>Ngày hồ sơ</strong></th>
									<th><strong>Đối tượng</strong></th>
									<th><strong>Loại hồ sơ</strong></th>
									<th><strong>SL đã cấp</strong></th>
									<th><strong>SL chưa sử dụng</strong></th>
								</tr>
							</thead>
							<tbody id="danhSachHoSoFilter">

							</tbody>
						</table>
					</div>
					<div style="width: 100%; height: 30px; display: flex;justify-content: space-between;">
						<div><span style="font-style: italic;color: #939393;"> Tổng số hồ sơ tìm thấy:</span><span style="color: red;font-style: small;" id="totalHoSo">2232</span></div>
						<ul style="margin: 0; padding:0;">
							<li style="list-style: none; display:inline;">
								<button style="background-color:#1867c0;border-color: #1867c0; color:#fff;width: 18px;"><</button>
							</li>
							<li style="list-style: none; display:inline;">
								<button style="background-color:#1867c0;border-color: #1867c0; color:#fff;width: 18px;">1</button>
							</li>
							<li style="list-style: none; display:inline;">
								<button style="background-color:#1867c0;border-color: #1867c0; color:#fff;width: 18px;">></button>
							</li>
						</ul>
					</div>
                </div>
                <div style="width:18%;">
					<div style="width:100%; display: flex; justify-content: center;">
						<button type="button" id="btn-import" class="btn btn-active">Import Excel</button>
					</div>
					<div style="width:100%; display: flex; justify-content: center;">
						<button type="button" class="btn btn-active">Export Excel</button>
					</div>
					<div style="width:100%; display: flex; justify-content: center;">
						<button type="button" class="btn btn-active">In phiếu</button>
					</div>
					<div style="width:100%; display: flex; justify-content: center;">
						<button type="button" class="btn btn-active">Báo hỏng, báo mất</button>
					</div>
					<div style="width:100%; display: flex; justify-content: center;">
						<button type="button" id="btn-cauhinh" class="btn btn-active">Cấu hình phôi XCG</button>
					</div>	   
                </div>
            </div>
		</div>
		<#--	-->
		<div id="wrapMain" class="table-responsive">
			<div style="display: flex;align-items: center;"><div class="triangle-right"></div><strong>Danh sách xe</strong></div>
			<div style="width: 100%;">
				<div class="filter-group" style="width: 20%;">
					<label for="noGCN">Số GCN</label>
					<input type="text" class="form-control" id="noGCN" >
				</div>
				<div class="filter-group" style="width: 20%;">
					<label for="noGCN">Trạng thái</label>
					<select class="form-control" id="">
						<option>Đã in</option>
						<option>Chưa in</option>
					</select>
				</div>
			</div>
			<div style="width: 100%; display: flex;">
				<table class="table table-bordered M0" style="width:50%">
					<#-- Table header -->
					<thead>
						<tr>
							<th>
								<span>Chọn</span><input type="checkbox" >
							</th>
							<th class="text-center hover-pointer">
								<span>STT</span>
							</th>
							<th class="fieldDossier text-center hover-pointer PL0 PR5" sort="dossierId" sort-type="desc">
								<span>Số GCN </span>
							</th>
							<th class="fieldDossier text-center hover-pointer" sort="submitDate" sort-type="desc">
								<strong>Số khung</strong>
							</th>
							<th class="text-center hover-pointer">
								<strong>Số động sơ</strong>
							</th>
							<th class="text-center hover-pointer">
								<strong>Màu sơn</strong>
							</th>
							<th class="text-center hover-pointer">
								
							</th>
						</tr>
					</thead>
					<#-- Table body -->
					<tbody id="danhSach">
				
					</tbody>
				</table>
				<div id="preview" style="width: 50%; border-left: 0.5px solid;">
					<div style="width: 100%;margin-left:15px;display:flex;">
						<strong style="margin-right: 5px;">Xem bản thảo: </strong>
						<input type="radio" name="previewBanThao" value="PDF" style="margin-left: 5px;">PDF
						<input type="radio" name="previewBanThao" value="HTML" style="margin-left: 5px;">HTML
					</div>
					<object id="viewPDF" data="https://www.w3docs.com/uploads/media/default/0001/01/540cb75550adf33f281f29132dddd14fded85bfc.pdf" type="application/pdf" style="width:100%; height: 400px;">
						<embed src="https://www.w3docs.com/uploads/media/default/0001/01/540cb75550adf33f281f29132dddd14fded85bfc.pdf" type="application/pdf" />
					</object>
					<div id="viewHTML" style="position: relative;">

					</div>
				</div>
			</div>


		</div>
		<div class="footerListProfile row-header col-sm-12 PT20 PR0" style="background: #f6f6f6">
			<div class="clearfix align-middle" style="float: right">
				<span class="text-light-gray MR15"><i>Tổng số <span id="totalItem_dossierList" class="red"></span> kết quả được tìm thấy</i></span>
				<span class="show-per-page MT0">Hiển thị
					<span class="select-wrapper">
						<select class="ML5" id="itemPpage" style="background-color: #ffffff">
							<option value="10">10</option>
							<option value="20">20</option>
							<option value="50">50</option>
							<option value="100">100</option>
						</select>
					</span>
				</span>
				<span id="pagerProfile" class="M0 P0" data-role="pager" data-info="false" data-bind="source: dataSourceProfile, events:{change: stylePager}" data-button-count="10" style="background: #ffffff" data-auto-bind="false"></span>
			</div>	
		</div>
</div>
<script>
	var	groupId = window.themeDisplay.getScopeGroupId()
	document.body.scrollTop = 0;
	document.documentElement.scrollTop = 0;
	document.getElementById("danhSachAnChiCapPhat").style.background= "#fff0"
	document.getElementById("danhSachXeXuatXuong").style.background= "#fff0"
	document.getElementById("danhSachXeChoInPhieuXuatXuong").style.background= "linear-gradient(to right, #ffeaa0 0%,rgba(246,246,246,0) 100%)"
	var originUrl = window.location.href.substr(0, window.location.href.lastIndexOf('/group'))
	function fullScreen(){
		$("#fullScreen").children().toggle();
		$("#panel_list").toggle();
		$("#mainType2").toggleClass("col-sm-10","col-sm-12");

	}
	var table =  $('#danhSach')
	var previewType ='PDF'
	$(function() {
		var $radios = $('input:radio[name=previewBanThao]');
		if($radios.is(':checked') === false) {
			$radios.filter('[value=PDF]').prop('checked', true);
		}
	});
	if(previewType === 'PDF'){
		document.getElementById("viewPDF").style.display = "block";
		document.getElementById("viewHTML").style.display = "none";
	}
	if(previewType === 'HTML'){
		document.getElementById("viewPDF").style.display = "none";
		document.getElementById("viewHTML").style.display = "block";	
	}
	function showHTML(){
		previewType ='HTML'
		document.getElementById("viewPDF").style.display = "none"
		document.getElementById("viewHTML").style.display = "flex"
	}
	function showPDF(){
		previewType ='PDF'
		document.getElementById("viewPDF").style.display = "flex"
		document.getElementById("viewHTML").style.display = "none"
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
				dictGroups = success.data
				let select = document.getElementById("vehicleclassFilter");
				dictGroups.forEach(function(item){
					let option = document.createElement("option");
					option.text = item.groupCode;
					option.value = item.groupCode;
					select.appendChild(option);
				})
			},
		})
	}
	function inputCheck(cb, item){
		console.log(cb.checked)
		console.log(item)
	}
	table.find('input').each( function (index){
		$(this).on('click', function () {
			console.log(list[index])
			let valCheckBox = $(this)
			console.log(valCheckBox)
			if(valCheckBox.is(':checked')){
				valCheckBox.attr('value', 'true');
			}else{
				valCheckBox.attr('value', 'false');
			}

			console.log(valCheckBox.val())
		})
	})
	function xemBanThao(i){
		console.log('xemBanThao', i)
		$('#viewHTML').html('<div style="background-size: cover; height: 297mm; width: 210mm; margin-left: auto; margin-right: auto; position: relative; background-image: url(&quot;http://kiemthu.mt.gov.vn:5001/documents/55217/620501/XCG.PNG/30831dfd-5fb3-3f3f-944e-b8fadd74d292?version=1.0&amp;t=1576555287326&amp;imagePreview=1&quot;);"><div id="nhanhieu" title="nhanhieu" style="z-index: 99; position: absolute; left: 263px; top: 145px;" class="ui-draggable ui-draggable-handle">nhanhieu</div><div id="mauson" title="mauson" style="z-index: 99; position:absolute; left : 490px; top : 123px;" class="ui-draggable ui-draggable-handle">mauson</div></div>')
	}
	$('input[type=radio][name=previewBanThao]').change(function() {
		if (this.value == 'PDF') {
			showPDF();
		}
		else if (this.value == 'HTML') {
			showHTML();
		}
	});
	function selectHoSo(issueid) {
		let Url = originUrl + '/o/rest/vr-app/vehicle/record/search?issueid=' + issueid
		$.ajax({
			url: Url,
			type: "GET",
			success: function (success) {
				let html = '';
				for(let i=0; i< success.data.length; i++){
					html += '<tr class="rowTable">'
						+	'<td class="text-center"><input type="checkbox" id="checkbox'+(i+1)+'" value="false"></td>'
							+	'<td class="text-center">'+ (i+1) + '</td>'
							+	'<td class="text-center">'+ success.data[i].certificaterecordno + '</td>'
							+	'<td class="text-center">'+ success.data[i].frameno + '</td>'
							+	'<td class="text-center">'+ success.data[i].engineno + '</td>'
							+	'<td class="text-center">'+ success.data[i].color + '</td>'
							+	'<td class="text-center"><span style="color: #0b72ba; font-weight: bold;" onclick="xemBanThao('+i+')">Xem</span></td>'
						+	'</tr>'
				}
				document.getElementById("danhSach").innerHTML = html
			},
		});
	}
	function getDSHoSo () {

		let Url = originUrl + '/o/rest/vr-app/issue/search?used=false'
		let params = {
			vehicleclass:document.getElementById("vehicleclassFilter").value,
			issuetype: document.getElementById("issuetypeFilter").value
		}
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
					html += '<tr class="rowTable">'
						+	'<td class="text-center"><input type="radio" name="radioHoSo" onclick="selectHoSo('+success.data[i].id+')"></td>'
							+	'<td class="text-center">'+ success.data[i].stampissueno + '</td>'
							+	'<td class="text-center">'+ success.data[i].applieddate + '</td>'
							+	'<td class="text-center">'+ success.data[i].vehicleclass + '</td>'
							+	'<td class="text-center">'+ success.data[i].issuetype + '</td>'
							+	'<td class="text-center">'+ success.data[i].totalindocument + '</td>'
							+	'<td class="text-center">'+ success.data[i].totalnotused + '</td>'
						+	'</tr>'
				}
				document.getElementById("danhSachHoSoFilter").innerHTML = html
				document.getElementById("totalHoSo").innerHTML = success.total
				
				
			},
		});	
	}
	getDSHoSo ()
	var dialog = $("#dialog").kendoDialog({
		width: "500px",
		buttonLayout: "normal",
		title: "",
		closable: true,
		modal: false,
		content: "<p>Bạn có chắc chắn thực hiện thao tác này?<p>",
		actions: [
			{ 
				text: 'Có',
				primary: true,
				action: function(e){
					console.log('Có')
					return true;
				}
			},
			{ 
				text: 'Không',
				action: function(e) {
					console.log('Không')
					return true;	
				}
			}
		]
	});
	dialog.data("kendoDialog").close();

	$("#btn-import").click(function(){
		dialog.data("kendoDialog").open();
	});

	var listLabel = [{name: 'nhanhieu',}, {name: 'loaixe'}, {name: 'mauson'}, {name: 'soloai'}]

	function fillListLabel(list) {
		$("#list-label").html('')
		for(let i=0; i<list.length; i++) {
			$("#list-label").append('<div id="item-'+list[i].name+'" style="width: 100%; height: 30px; padding: 5px;display: flex;align-items: center;justify-content: space-between;border-bottom: 1px solid;box-sizing: border-box;"><span>'+list[i].name+'</span><i id="addLabel'+list[i].name+'" class="fa fa-plus" aria-hidden="true" style="color: #2196f3;"></i></div>')
			$('#addLabel'+list[i].name).click(function(){
				// Xóa label trong filter và list label
			
			
				// Thêm label vào phôi
				$("#printTraCuu").append('<div id=' + list[i].name + ' title=' + list[i].name + ' style="z-index: 99; position:absolute; left : ' + 490 + 'px; top : ' + 123 + 'px;">' + list[i].name + '</div>');
				// Thêm event draggable vào label
				$('#' + list[i].name ).draggable({
					stop: function() {


					}
				});
				// Thêm event mousedown vào label
				$('#' + list[i].name).mousedown(function(event) {
					if(event.which===3){
						$('#dialog-cauhinh').append(`
							<div id="tooltip-`+list[i].name+`" style="position: absolute;top: 0px; left: 0px; width: 180px;box-shadow: -3px 6px 16px #888888;background-color: #fff; padding: 10px;display: none;z-index: inherit;">
								<i id="close-tooltip-`+list[i].name+`" class="fa fa-times" aria-hidden="true" style="position: absolute; top: 0px; right: 0px;"></i>
								<div style="width: 100%; height: 30px;display: flex;">
									<strong style="width: 50%;">Font size:</strong>
									<div style="width: 50%;padding: 3px; box-sizing: border-box;"><input  id="input-size-`+list[i].name+`"  style="width: 100%;" type="" name=""></div>
									
								</div>
								<div style="width: 100%;height: 30px;display: flex;">
									<strong style=" width: 50%;">Màu sắc:</strong>
									<div style="width: 50%;padding: 3px; box-sizing: border-box;"><input id="input-mau-`+list[i].name+`" type="color" style="width: 100%;" type="" name=""></div>
								</div>
								<div style="width: 100%;height: 30px;display: flex;">
									<strong style=" width: 50%;">Chiều dài:</strong>
									<div style="width: 50%;padding: 3px; box-sizing: border-box;"><input id="input-width-`+list[i].name+`" style="width: 100%;" type="" name=""></div>
								</div>
								<div style="width: 100%;height: 30px;display: flex;">
									<strong style=" width: 50%;">Chiều rộng:</strong>
									<div style="width: 50%;padding: 3px; box-sizing: border-box;"><input id="input-height-`+list[i].name+`" style="width: 100%;" type="" name=""></div>
								</div>
							</div>
						`)
						$('#tooltip-'+ list[i].name).css({
							top: event.pageY + 'px',
							left: event.pageX + 'px'
						}).fadeIn(250);
						$("#input-size-"+ list[i].name).change(function(){
							$('#' + list[i].name ).css('font-size', $("#input-size-"+ list[i].name).val() + 'px')
						})
						$("#input-mau-"+ list[i].name).change(function(){
							$('#' + list[i].name ).css('color', $("#input-mau-"+ list[i].name).val())
						})
						$("#input-width-"+ list[i].name).change(function(){
							$('#' + list[i].name ).css('width', $("#input-width-"+ list[i].name).val())
						})
						$("#input-height-"+ list[i].name).change(function(){
							$('#' + list[i].name ).css('height', $("#input-height-"+ list[i].name).val())
						})
						$("#close-tooltip-"+ list[i].name).click(function(){
							$("#tooltip-"+ list[i].name).remove()
						})
					}
				});
				$('#item-' + list[i].name).css("display","none")
				for(let j = 0; j < listLabel.length ; j++) {
					if(listLabel[j].name === list[i].name){
						listLabel.splice(j, 1)
					}
				}

			})
		}

	}
	$(document).ready(function() { 
		$('#printTraCuu').css('background-image', 'url('+ originUrl +'/documents/55217/620501/XCG.PNG/30831dfd-5fb3-3f3f-944e-b8fadd74d292?version=1.0&t=1576555287326&imagePreview=1)');
		$("#input-label").change(function(){
			if($("#input-label").val() === ''){
				$("#list-label").html('')
				let list = [...listLabel]
				fillListLabel(list)
			}
			else{
				let result = listLabel.filter(item=>{
					if(item.name.includes($("#input-label").val())){
						return item
					}
				})
				$("#list-label").html('')
				fillListLabel(result)
			}
		}); 
		$('#vehicleclassFilter').change(function(){
			getDSHoSo()
		})
		$('#issuetypeFilter').change(function (){
			getDSHoSo()
		})
		$("#btn-cauhinh").click(function(){
			document.getElementById("dialog-cauhinh").style.display = "block"
			let list = [...listLabel]
			fillListLabel(list)
			$("#printTraCuu").html('')
		});
		$("#btn-close-cauhinh").click(function(){
			document.getElementById("dialog-cauhinh").style.display = "none"
		});
		$('#btn-save-cauhinh').click(function(){
			$('#printTraCuu').printThis();
			console.log($('#printTraCuu'))
		})
	}); 
	getDictGroups()
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
    .table-hoso-filter{
        width: 100%;
        border: 0.5px solid;
		max-height: 200px;
    	overflow: scroll;
    }
    .table-hoso-filter th, .table-hoso-filter td{
        border-right: 0.5px solid;
        border-bottom: 0.5px solid;
    }
    .table-hoso-filter tr th:last-child, .table-hoso-filter tr td:last-child{
        border-right: 0px solid;
       
    }
    .table-hoso-filter tr:last-child td{
        border-bottom: 0px solid;
    }
	.triangle-right {
		width: 0;
		height: 0;
		border-top: 7px solid transparent;
		border-left: 21px solid #4e839d;
		border-bottom: 6px solid transparent;
	}
	.k-dialog .k-dialog-buttongroup.k-dialog-button-layout-normal {
		display: flex;
		justify-content: flex-end;
	}
	.k-window{
		box-shadow: -1px 5px 12px 12px rgba(128,128,128,.3)!important;
	}

</style>
