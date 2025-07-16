// Variables globales
let fotoIdActual = null;
let modal = null;

// Inicialización cuando carga la página
document.addEventListener('DOMContentLoaded', function() {
    modal = new bootstrap.Modal(document.getElementById('eliminarModal'));
});

/**
 * Muestra el modal de confirmación para eliminar una foto
 * @param {string} fotoId - ID de la foto
 * @param {string} nombreFoto - Nombre de la foto
 */
function mostrarModalEliminar(fotoId, nombreFoto) {
    fotoIdActual = parseInt(fotoId);
    document.getElementById('fotoNombre').textContent = nombreFoto;
    document.getElementById('motivo').value = '';
    modal.show();
}

/**
 * Elimina una foto después de confirmar
 */
function eliminarFoto() {
    if (fotoIdActual === null) {
        mostrarAlerta('Error: No se ha seleccionado una foto', 'danger');
        return;
    }
    
    const motivo = document.getElementById('motivo').value.trim();
    
    // Validar que el motivo no esté vacío
    if (!motivo) {
        mostrarAlerta('El motivo es obligatorio', 'danger');
        return;
    }
    
    // Validar longitud del motivo
    if (motivo.length > 200) {
        mostrarAlerta('El motivo no puede exceder 200 caracteres', 'danger');
        return;
    }
    
    // Mostrar loading
    mostrarAlerta('Eliminando foto...', 'info');
    
    // Realizar llamada asíncrona con fetch
    fetch(`/api/foto/${fotoIdActual}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: `motivo=${encodeURIComponent(motivo)}`
    })
    .then(response => {
        if (response.ok) {
            return response.json();
        } else if (response.status === 404) {
            throw new Error('Foto no encontrada');
        } else {
            throw new Error('Error del servidor');
        }
    })
    .then(data => {
        if (data.success) {
            // Remover la tarjeta de la foto del DOM
            const fotoCard = document.getElementById(`foto-card-${fotoIdActual}`);
            if (fotoCard) {
                fotoCard.style.animation = 'fadeOut 0.5s ease-out';
                setTimeout(() => {
                    fotoCard.remove();
                    verificarSinFotos();
                }, 500);
            }
            
            // Cerrar modal
            modal.hide();
            
            // Mostrar mensaje de éxito
            mostrarAlerta('Foto eliminada exitosamente', 'success');
            
            // Resetear variables
            fotoIdActual = null;
        } else {
            mostrarAlerta(data.message || 'Error al eliminar la foto', 'danger');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        mostrarAlerta('Error de conexión al servidor: ' + error.message, 'danger');
    });
}

/**
 * Verifica si quedan fotos y muestra mensaje apropiado
 */
function verificarSinFotos() {
    const fotoCards = document.querySelectorAll('[id^="foto-card-"]');
    if (fotoCards.length === 0) {
        const container = document.querySelector('.row');
        container.innerHTML = `
            <div class="col-12">
                <div class="text-center mt-5">
                    <div class="alert alert-info">
                        <h4>No hay fotos disponibles</h4>
                        <p>Todas las fotos han sido eliminadas del sistema.</p>
                    </div>
                </div>
            </div>
        `;
    }
}

/**
 * Muestra una alerta en la interfaz
 * @param {string} mensaje - Mensaje a mostrar
 * @param {string} tipo - Tipo de alerta (success, danger, info, warning)
 */
function mostrarAlerta(mensaje, tipo) {
    const alertContainer = document.getElementById('alert-container');
    
    // Remover alertas existentes
    alertContainer.innerHTML = '';
    
    const alertDiv = document.createElement('div');
    alertDiv.className = `alert alert-${tipo} alert-dismissible fade show`;
    alertDiv.innerHTML = `
        ${mensaje}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    `;
    
    alertContainer.appendChild(alertDiv);
    
    // Auto-hide después de 5 segundos para alertas de éxito e info
    if (tipo === 'success' || tipo === 'info') {
        setTimeout(() => {
            if (alertDiv.parentNode) {
                alertDiv.remove();
            }
        }, 5000);
    }
}

// Agregar animación CSS para fadeOut
const style = document.createElement('style');
style.textContent = `
    @keyframes fadeOut {
        from {
            opacity: 1;
            transform: scale(1);
        }
        to {
            opacity: 0;
            transform: scale(0.9);
        }
    }
`;
document.head.appendChild(style);

// Manejo de eventos para el modal
document.getElementById('eliminarModal').addEventListener('shown.bs.modal', function() {
    document.getElementById('motivo').focus();
});

// Permitir eliminar con Enter en el textarea
document.getElementById('motivo').addEventListener('keypress', function(e) {
    if (e.key === 'Enter' && e.ctrlKey) {
        eliminarFoto();
    }
});

// Contador de caracteres para el motivo
document.getElementById('motivo').addEventListener('input', function() {
    const maxLength = 200;
    const currentLength = this.value.length;
    const formText = this.parentNode.querySelector('.form-text');
    
    if (currentLength > maxLength * 0.8) {
        formText.innerHTML = `${currentLength}/${maxLength} caracteres`;
        formText.className = 'form-text text-warning';
    } else {
        formText.innerHTML = `Máximo ${maxLength} caracteres`;
        formText.className = 'form-text';
    }
    
    if (currentLength > maxLength) {
        this.value = this.value.substring(0, maxLength);
    }
});
