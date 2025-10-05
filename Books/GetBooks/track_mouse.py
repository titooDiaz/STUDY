import subprocess
import time

def get_mouse_position():
    """Devuelve la posición (x, y) del mouse usando xdotool"""
    output = subprocess.check_output(["xdotool", "getmouselocation"]).decode()
    x = int(output.split()[0].split(":")[1])
    y = int(output.split()[1].split(":")[1])
    return (x, y)

print("📍 Presiona Ctrl+C para salir")
try:
    while True:
        pos = get_mouse_position()
        print(f"Posición del mouse: {pos}", end="\r")  # Sobrescribe la misma línea
        time.sleep(0.1)  # Actualiza cada 0.1 segundos
except KeyboardInterrupt:
    print("\n✅ Programa terminado")

