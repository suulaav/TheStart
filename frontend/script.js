document.addEventListener("DOMContentLoaded", function () {
    const itemForm = document.getElementById("itemForm");
    const responseDiv = document.getElementById("response");
    const openModalButton = document.getElementById("openModalButton");
    const closeModalButton = document.getElementById("closeModalButton");
    const modal = document.getElementById("modal");

    openModalButton.addEventListener("click", function () {
        modal.style.display = "block";
    });

    closeModalButton.addEventListener("click", function () {
        modal.style.display = "none";
    });

    function displayItemList() {
        fetch("https://suulaav.com.np/backend/documents")
            .then((response) => response.json())
            .then((data) => {
                itemList.innerHTML = ""; // Clear the previous list
                data.forEach((item) => {
                    const listItem = document.createElement("li");
                    listItem.textContent = `ID: ${item.id}, Name: ${item.name}, Quantity: ${item.quantity}, Category: ${item.category}`;
                    itemList.appendChild(listItem);
                });
            })
            .catch((error) => {
                console.error("Error fetching items: " + error);
            });
    }
    displayItemList();

    itemForm.addEventListener("submit", function (event) {
        event.preventDefault();

        const id = document.getElementById("id").value;
        const name = document.getElementById("name").value;
        const quantity = parseInt(document.getElementById("quantity").value);
        const category = document.getElementById("category").value;

        const itemData = {
            id: id,
            name: name,
            quantity: quantity,
            category: category,
        };

        fetch("https://suulaav.com.np/backend/documents", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(itemData),
        })
            .then((response) => response.json())
            .then((data) => {
                responseDiv.textContent = "POST request successful. Response: " + JSON.stringify(data);
            })
            .catch((error) => {
                responseDiv.textContent = "Error: " + error;
            });
    });
});
