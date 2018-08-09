/*dropdown() allows user to click an item and more info will drop down */
function dropdown(id) {

	// select html elements and store them in variables
	// element to click
	const dropdownClick = document.getElementById(id);
	// element to be revealed
	const dropdownReveal = dropdownClick.nextElementSibling;
	//arrow shaped icon
	const arrowIcon = dropdownClick.children[0].children[1].children[0];

	// if dropdownReveal is not displayed then display
	// else hide the dropdownReveal
	if(window.getComputedStyle(dropdownReveal).getPropertyValue('display') === 'none') {
		dropdownReveal.style.display = 'flex';
		arrowIcon.classList.remove('fa-angle-down');
		arrowIcon.classList.add('fa-angle-up');
	} else {
		dropdownReveal.style.display = 'none';
		arrowIcon.classList.remove('fa-angle-up');
		arrowIcon.classList.add('fa-angle-down');
	}
}

/* toggleMenu() allows user to toggle the responsive hamburger menu on and off */
function toggleMenu() {
	// choose the html elements and assign them to variables
	const menuIcon = document.getElementById('hamburger-menu'),
		menuItems = document.getElementById('menu-items'),
		unicodeLabel = menuIcon.children[0],
		cross = '&#10006;',
		hamburger = '&#9776;';

	// if responsive menu is not displayed then display
	// else hide the responsive menu
	if(window.getComputedStyle(menuItems).getPropertyValue('display') === 'none') {
		unicodeLabel.innerHTML = cross;
		menuItems.style.display = 'flex';
	} else {
		unicodeLabel.innerHTML = hamburger;
		menuItems.style.display = 'none';
	}
}
