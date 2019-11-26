$(document).ready(
	function() {
		switch (menu) {
		case 'About Us':
			$('#about').addClass('active');
			$('#home').removeClass('active');
			break;
		case 'Contact Us':
			$('#contact').addClass('active');
			$('#home').removeClass('active');
			break;
		case 'All Products':
			$('#listProducts').addClass('active');
			$('#home').removeClass('active');
			break;
		case 'Manage products':
			$('#manageProducts').addClass('active');
			$('#home').removeClass('active');
			break;
		default:
			$('#home').addClass('active');
			$('#a_'+menu).addClass('active');
			break;
		}
		
		var table = $('#productListTable');
		if(table.length){
			var jsonURL = '';
			if(window.categoryId == ''){
				jsonURL = window.contextRoot + '/json/data/all/products';
			}else{
				jsonURL = window.contextRoot + '/json/data/category/'+window.categoryId+'/products'; 
			}
			
			table.DataTable({
				ajax:{
					url : jsonURL,
					dataSrc : '' // this is used for json parsing ie we are getting the json array without any name
				},
				columns : [
					{data : 'code',
						mRender : function(data,type,row){
							return "<img src='"+window.contextRoot+"/resources/Images/"+data+".jpg' class='imgdimensions'></img>";
						}
					},
					{data :'name'},
					{data :'brand'},
					{data :'unit_price',
					 mRender : function(data,type,row){
						 return '&#8377 '+data;
					 }
					},
					{data :'quantity',
						mRender : function(data,type,row){
							if(data < 1){
								return "<span style='color:red'>Out of Stock</span>";
							}else{
								return data;
							}
						}
					},
					{data :'id',
						bSortable : false,
						 mRender : function(data,type,row){
							 var str1 = "";
							 if(row.quantity < 1){
								  str1 = '<a class="btn btn-success disabled" href = "javascript:void(0)"><span class="glyphicon glyphicon-eye-open">Add To Cart</span></a>';
							 }else{
								  str1 = '<a class="btn btn-success" href = "'+window.contextRoot + '/cart/add/'+data+'/product"><span class="glyphicon glyphicon-eye-open">Add To Cart</span></a>';
							 }
							 var str = '<a class="btn btn-primary" href = "'+window.contextRoot + '/show/'+data+'/product" ><span class="glyphicon glyphicon-eye-open">View</span></a>';
							 return str+"   "+str1;
						 }
					}
				]
			});
		}
		
		
		var adminTable = $('#adminProductList');
		if(adminTable.length){
			var jsonURL = window.contextRoot + '/json/data/admin/all/products';
			adminTable.DataTable({
				ajax: {
					url : jsonURL,
					dataSrc : ''
				},
				columns : [
					{data:'id'},
					{data:'code',
						mRender : function(data,type,row){
							return "<img src='"+window.contextRoot+"/resources/Images/"+data+".jpg' class='productimgdimensions'></img>";
						}
					},
					{data:'name'},
					{data:'unit_price'},
					{data:'quantity',
						mRender : function(data,type,row){
							if(data == '0'){
								 return '<span style="color:red">Out of Stock</span>';
							}else{
								return data;
							}
						}
					},
					{data:'is_active',
						bSortable : false,
						mRender : function(data,type,row){
							var str = '';
							if(data == true){
								str = '<label class="switch"><input type="checkbox" value="'+row.id+'" checked><span class="slider round"></span></label>';
							}else{
								str = '<label class="switch"><input type="checkbox" value="'+row.id+'"><span class="slider round"></span></label>';
							}
							return str;
						}	
					},
					{data:'id',
						bSortable : false,
						mRender : function(data,type,row){
							 return '<a class="btn btn-warning" href = "'+window.contextRoot+'/manage/'+data+'/product"><span class="glyphicon glyphicon-pencil">Edit</span></a>';
						}
					}
				],
				initComplete : function(){
					var api = this.api();
					api.$('.switch input[type="checkbox"]').on('change',function(){
						var check = $(this);
						var checked = check.prop('checked');
						var value = check.prop('value');
						var dmsg = (checked) ? "Do you want to Deactivate the Product?" : "Do you want to Activate the Product?";
						bootbox.confirm({
							title : 'Product Activation & Deactivation',
							size : 'medium',
							message:dmsg,
							callback: function (result) {
								if(result){
									var url = window.contextRoot + '/manage/products/'+value+'/activate';
									$.post(url,function(data){
										bootbox.alert({
										    message: data,
										    size: 'medium'
										});
									});
								}else{
									check.prop('checked',!checked);
								}
							}
						});
				});
				}
			});
		}
		
		var categroyTable = $('#categoryFormId');
		if(categroyTable.length){
			categroyTable.validate({
				rules : {
					name : {
						required : true,
						minlength : 2
					},
					desc : {
						required : true
					}
				},
				messages:{
					name : {
						required : 'Please enter the Category Name.',
						minlength : 'Category Name should be greater than 2 Characters.'
					},
					desc : {
						required : 'Please enter the Description'
					}
				},
				errorElement : 'em',
				errorPlacement : function(error,element){
					error.addClass('form-text');
					error.insertAfter(element);
				}
			});
		}
		
	}
);