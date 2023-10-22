const urlParams = new URLSearchParams(window.location.search);
let id = urlParams.get('id');

const BASE_URL = 'http://localhost:8080';
        const ENDPOINT = '/carDetails';
        const QUERY = '?id=' + id;
        const url = `${BASE_URL}${ENDPOINT}${QUERY}`;

        async function fetchData() {
            try {
                let response = await fetch(url);

                if (!response.ok) {
                    throw new Error(`Błąd HTTP: ${response.status} ${response.statusText}`);
                }

                let data = await response.json();
                populateSlider(data);
                populateCarDetails(data);
                populateAdditionalInfo(data);
                populatePriceTable(data);

            } catch (error) {
                console.error('Błąd pobierania danych:', error);
                showError();
            }
        }

        function showError() {
            const container = document.querySelector('.container');
            container.innerHTML = `
                <div class="alert alert-danger" role="alert">
                    Przepraszamy, wystąpił błąd podczas ładowania danych. Spróbuj ponownie za chwilę lub skontaktuj się z nami, jeśli problem będzie się powtarzał.
                </div>
            `;
        }

        function reservation() {
            if(urlParams.has('pickupDate') && urlParams.has('returnDate'))
            {
                let pickupDate = urlParams.get('pickupDate');
                let returnDate = urlParams.get('returnDate');
                window.location.href = 'rezerwacja.html?id=' + id + '&pickupDate=' + pickupDate + '&returnDate=' + returnDate;
            }else{
                window.location.href = 'rezerwacja.html?id=' + id;
            }
        }

        function populateSlider(carData) {
            const carouselInner = document.getElementById('carouselInner');
            carouselInner.innerHTML = '';
        
            carData.photoList.forEach((photo, index) => {
                    let carouselItem = document.createElement('div');
                    carouselItem.className = 'carousel-item';
            
                    if (index === 0) {
                        carouselItem.classList.add('active');
                    }
            
                    let imgElement = document.createElement('img');
                    imgElement.src = photo.src;
                    imgElement.alt = photo.alt || `Zdjęcie samochodu ${carData.make} ${carData.model}`;
                    imgElement.className = 'd-block w-100';
            
                    // Dodanie atrybutu loading="lazy" dla obrazów, które nie są pierwszym obrazem w karuzeli
                    if (index !== 0) {
                        imgElement.setAttribute('loading', 'lazy');
                    }
            
                    let anchorElement = document.createElement('a');
                    anchorElement.href = photo.src;
                    anchorElement.setAttribute('data-lightbox', 'carSlider');
                    anchorElement.setAttribute('data-title', photo.alt || `Zdjęcie samochodu ${carData.make} ${carData.model}`);
                    anchorElement.appendChild(imgElement);
            
                    carouselItem.appendChild(anchorElement);
                    carouselInner.appendChild(carouselItem);
                
            });
        }

        function populateAdditionalInfo(carData) {
            const detailsList = document.getElementById('detailsList');
            const equipmentList = document.getElementById('equipmentList');
            const rentalTermsList = document.getElementById('rentalTermsList');

            detailsList.innerHTML = `
                <li>Marka: ${sanitize(carData.make)}</li>
                <li>Model: ${sanitize(carData.model)}</li>
                <li>Pojemność silnika: ${sanitize(carData.engineSize)} L</li>
                <li>Rodzaj paliwa: ${sanitize(carData.fuelType)}</li>
                <li>Liczba drzwi: ${sanitize(carData.numberOfDoors)}</li>
                <li>Rodzaj skrzyni biegów: ${sanitize(carData.transmissionType)}</li>
            `;

            equipmentList.innerHTML = carData.equipmentList.map(equip => `<li>${sanitize(equip)}</li>`).join('');
            rentalTermsList.innerHTML = carData.rentalConditionList.map(condition => `<li>${sanitize(condition)}</li>`).join('');
        }

        function populateCarDetails(carData) {
            document.getElementById('car-make').textContent = "Marka: " + carData.make;
            document.getElementById('car-model').textContent = "Model: " + carData.model;
            document.getElementById('car-year').textContent = "Rok Produkcji: " + carData.productionYear;
            document.getElementById('car-description').textContent = "Opis: " + carData.description;
        }

        function populatePriceTable(carData) {
            const priceTableBody = document.getElementById('priceTableBody');
            carData.rateList.sort((a, b) => a.minDays - b.minDays);
            priceTableBody.innerHTML = '';

            carData.rateList.forEach(rate => {
                const row = document.createElement('tr');

                const periodCell = document.createElement('td');
                periodCell.textContent = `${rate.minDays} - ${rate.maxDays === 0 ? 'więcej' : rate.maxDays} dni`;

                const dailyRateCell = document.createElement('td');
                dailyRateCell.textContent = `${rate.dailyRate.toFixed(2)} zł`;

                row.appendChild(periodCell);
                row.appendChild(dailyRateCell);
                priceTableBody.appendChild(row);
            });
        }

        function sanitize(input) {
            const div = document.createElement('div');
            div.textContent = input;
            return div.innerHTML;
        }


        document.getElementById('contactForm').addEventListener('submit', function(e) {
            e.preventDefault();

            // Pobierz wartości z pól input
            let name = document.querySelector('input[name="name"]').value;
            let email = document.querySelector('input[name="email"]').value;
            let message = document.querySelector('textarea[name="message"]').value;

            // Stworzenie obiektu z danymi do wysłania
            let formData = {
                name: name,
                email: email,
                message: message
            };

            // Wysłanie danych za pomocą AJAX
            fetch('http://localhost:8080/sendMessage', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formData)
            })
            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
                alert('Wiadomość została wysłana!');
            })
            .catch((error) => {
                console.error('Error:', error);
                alert('Wystąpił błąd podczas wysyłania wiadomości. Spróbuj ponownie później.');
            });
        });

        fetchData();

        lightbox.options.responsive = true;