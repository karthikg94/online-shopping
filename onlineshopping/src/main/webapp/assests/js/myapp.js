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
					dataSrc : ''
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
					{data :'quantity'},
					{data :'id',
						bSortable : false,
						 mRender : function(data,type,row){
							 var str = '<a class="btn btn-primary" href = "'+window.contextRoot + '/show/'+data+'/product" ><span class="glyphicon glyphicon-eye-open">View</span></a>';
							 var str1 = '<a class="btn btn-success" href = "'+window.contextRoot + '/cart/add/'+data+'/product"><span class="glyphicon glyphicon-eye-open">Add To Cart</span></a>';
							 return str+"   "+str1;
						 }
					}
				]
			});
		}

	}
	
	
);