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


