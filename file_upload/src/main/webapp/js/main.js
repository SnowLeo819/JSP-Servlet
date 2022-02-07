itemSlider = new Swiper("#main", {
	slidesPerView: "auto",
	loop: true,
	effect: "coverflow",
	centeredSlides: true,
	coverflowEffect: {
		rotate: 0,
		slideShadows: false,
		depth: 1000,
		stretch: 0,
	},
	pagination: {
		el: "#main .pagination",
		clickable: true,
	},
	mousewheel: true,
});