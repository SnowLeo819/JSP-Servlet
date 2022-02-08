$.ajax({
	url: "/ClockJsonList.do",
	//dataType: "json", // 넘어오는 데이터를 json으로 처리
	success: function(data) {
		consolo.log(data);
		const clockList = data.clockList;
		consolo.log(clockList);

		let output = "";
		$.each(clockList, function(i, item) {
			output += `
					<div class="section" id=""
						style="background-image:url('upload_clock/${item.clockRealImg}')">
						<div class="info">
							<p class="category" data-splitting>{$itm.category}</p>
							<p class="title" data-splitting>{$item.title}</p>
							<p class="depth" data-splitting>{$item.depth}</p>
							<p class="price" data-splitting>{$item.price}</p>
						</div>
					</div>
					`
		});
		$("#main").html(output);
		
		const fp = new fullpage("#main", {
			scrollBar: true,
			onLeave: function(original, destination, index) {
				//console.log(destination);
				moveChar(`.section:nth-child(${destination.index + 1}) .char`);
			}
		});
		
		Splitting();
		moveChar(`.section:nth-child(1) .char`);
		function moveChar(char) {
			gsap.from(char, {
				y: -200,
				opacity: 0,
				ease: "bounce",
				duration: 1.5,
				delay: 0.5,
				stagger: {
					amount: 1,
					from: "random"
				}
			});
		}

	}
})




