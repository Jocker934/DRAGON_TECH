@echo off
echo =====================================
echo 🐉 DRAGON TECH - PUSH AUTOMATICO GITHUB
echo =====================================

:: Navega al directorio del proyecto (ajusta la ruta si lo necesitas)
cd /d "%~dp0"

:: Muestra los cambios pendientes
git status

:: Agrega todos los cambios
git add .

:: Pide mensaje de commit
set /p mensaje=Escribe el mensaje del commit: 

:: Realiza el commit
git commit -m "%mensaje%"

:: Sincroniza con el remoto
git pull --rebase origin main

:: Sube al repositorio
git push origin main

echo -------------------------------------
echo ✅ Cambios subidos exitosamente a GitHub
echo -------------------------------------
pause
