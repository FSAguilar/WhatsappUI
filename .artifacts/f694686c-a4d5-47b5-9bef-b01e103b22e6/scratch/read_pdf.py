import pypdf
import sys

try:
    reader = pypdf.PdfReader('C:/Users/DIEGO/Downloads/Planificacion_WhatsApp_UI-1.pdf')
    for i, page in enumerate(reader.pages):
        print(f'=== PAGE {i+1} ===')
        print(page.extract_text())
except Exception as e:
    print(f'Error: {e}')
