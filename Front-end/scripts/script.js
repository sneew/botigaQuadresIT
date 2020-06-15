//ajax + jquery
$(function(){
	// declarem espais html on insertar
	var $insert = $('#insert');
	var $shopSelect = $('#selectShop');
	var $paintingList = $('#paintingList');
	var $selectShopToShow = $('#selectShopToShow');
	//rebem inputs
	var $shopName = $('#shopName');
	var $shopCapacity = $('#shopCapacity');
	var $paintingName = $('#paintingName');
	var $authorName = $('#authorName');
	//declarem urls
	var $baseUrl = "http://localhost:8080";
	var $url2 = "http://localhost/VistaBotigaQuadres";

	//GET franchises
	$.ajax({
		type: 'GET',
		url: $baseUrl + '/franchises',

		success: function(franchises){
			$.each(franchises, function(i, franchise){
				$frs = franchise;
				$insert.append(
					"<strong>" + franchise.franchiseName + ":</strong>"
				);
				console.log('success',franchise)
			});
		},
		error: function(){
			alert('error loading');
		}
	});

	//GET shops
	$.ajax({
		type: 'GET',
		url: $baseUrl + '/shops',

		success: function(shops){
			$.each(shops, function(i, shop){
				$shopSelect.append(
					"<option value='" + shop.id +"' >" + shop.shopName +  " (" + shop.shopCapacity +")</option>",
				)
				$selectShopToShow.append(
					"<option value='" + shop.id +"' id='" + shop.id +"' >" + shop.shopName +   " (" + shop.shopCapacity +")</option>",
				)
				console.log('success',shop)
			});
		},
		error: function(){
			alert('error loading');
		}
	});

	//GET paintings
	$('#selectShopToShow').on('change', function(){
		$paintingList.html("");
		var $shopId = $selectShopToShow.val();
		$.ajax({
			type: 'GET',
			url: $baseUrl + '/shops/'+ $shopId +'/paintings',
	
			success: function(paintings){
				
				$.each(paintings, function(i, painting){
					$paintingList.append(
						"<li>"+
							"<h3><strong>" + painting.paintingName  + "</strong></h3>" +
						"</li>"
					);
					console.log('success', painting)
				});
			},
			error: function(){
				alert('error loading');
			}
		});
	});
	

	//POST shops
	$('#add-shop').on('click', function() {

		var shop = {
			shopName: $shopName.val(),
			shopCapacity: $shopCapacity.val(),
		};
		
		$.ajax({
			type: 'POST',
			url: $baseUrl + '/franchises/1/shops',
			contentType: "application/json",
			data: JSON.stringify(shop),
			success: function(newShop){
				window.location.href=$url2;
				console.log('success',newShop)
			},
			error: function(){
				alert('error posting new shop');
			}
		});
	});

	//POST Paintings
	$('#add-painting').on('click', function() {
		
		var painting = {
			paintingName: $paintingName.val(),
			authorName: $authorName.val(),
		};
		
		$.ajax({
			type: 'POST',
			url: $baseUrl + '/shops/'+ $shopSelect.val() + '/paintings',
			contentType: "application/json",
			data: JSON.stringify(painting),
			success: function(newPainting){
				window.location.href=$url2;
				console.log('success',newPainting)
			},
			error: function(){
				alert('error posting new painting');
			}
		});
	});

	//DELETE
	$('#burn-paintings').on('click', function(){
		var $idshop = $selectShopToShow.val();
		console.log($idshop);
		$.ajax({
			type:'DELETE',
			url: $baseUrl + '/shops/' + $idshop + '/paintings',
			success: function(){
				window.location.href=$url2;
			}
		});
	});

});