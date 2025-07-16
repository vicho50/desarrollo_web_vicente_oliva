import os
from dotenv import load_dotenv

load_dotenv()

class Config:
    # Conexión a MySQL (usando las credenciales del PDF)
    SQLALCHEMY_DATABASE_URI = 'mysql+pymysql://cc5002:programacionweb@localhost:3306/tarea2'
    SQLALCHEMY_TRACK_MODIFICATIONS = False