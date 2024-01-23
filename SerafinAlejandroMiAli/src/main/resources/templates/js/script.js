document.getElementById('provincia').addEventListener('change', function() {
    var idProvincia = this.value;
    fetch('/municipios/' + idProvincia)
        .then(response => response.json())
        .then(data => {
            var municipioSelect = document.getElementById('municipio');
            municipioSelect.innerHTML = '';
            data.forEach(function(municipio) {
                var option = document.createElement('option');
                option.value = municipio.idMunicipio;
                option.text = municipio.nombre;
                municipioSelect.appendChild(option);
            });
        });
});
