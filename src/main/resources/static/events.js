// Get all the gallery images
const galleryImages = document.querySelectorAll('.gallery img');

// Add a click event listener to each image
galleryImages.forEach((image) => {
  image.addEventListener('click', () => {
    // Toggle the 'flipped' class to flip the image
    image.classList.toggle('flipped');
    // Toggle between the original image and the flipped image
    const altSrc = image.getAttribute('data-alt-src');
    if (altSrc) {
      const currentSrc = image.getAttribute('src');
      image.setAttribute('src', altSrc);
      image.setAttribute('data-alt-src', currentSrc);
    }
  });
});