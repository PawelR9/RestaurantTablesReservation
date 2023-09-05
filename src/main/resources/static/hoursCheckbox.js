// Pobierz wszystkie checkboxy
const checkboxes = document.querySelectorAll('input[type="checkbox"]');

// Obsługa zdarzenia zmiany stanu checkboxa
checkboxes.forEach((checkbox) => {
    checkbox.addEventListener('change', function () {
        // Pobierz odpowiednie pola godzin
        const fromInput = this.parentElement.querySelector('input[type="text"]');
        const toInput = fromInput.nextElementSibling;

        // Zablokuj lub odblokuj pola godzin w zależności od stanu checkboxa
        fromInput.disabled = this.checked;
        toInput.disabled = this.checked;
    });
});
