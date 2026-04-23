# Audio Output Switcher

[![Build Status](https://github.com/weslley75/AudioOutputSwitcher/actions/workflows/build.yml/badge.svg)](https://github.com/weslley75/AudioOutputSwitcher/actions/workflows/build.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![API](https://img.shields.io/badge/API-30%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=30)

Tiles de configurações rápidas (Quick Settings) para Android para controle de áudio: troca de dispositivo de saída e acesso ao painel de volume.

## 📱 Sobre

Este aplicativo adiciona dois tiles personalizados às Configurações Rápidas do Android. O tile **Audio Output** abre o seletor nativo de dispositivo de saída de áudio; o tile **Volume Panel** abre o painel de volume do sistema. Cada tile pode ser adicionado de forma independente — use um, os dois, ou nenhum.

## ✨ Funcionalidades

- 🎧 **Tile "Audio Output"**: acesso rápido ao seletor de dispositivo de saída de áudio
- 🔊 **Tile "Volume Panel"**: acesso direto ao painel de volume do sistema (mídia, notificações, alarme)
- 📌 Funciona como widget na home screen (ex: Nothing Phone) — ambos os tiles respondem ao toque simples
- 🔄 Integração com o sistema nativo do Android
- 🌐 Suporte a português brasileiro e inglês
- 📱 Compatível com Android 11+ (API 30+), compilado com API 36
- ⚡ Leve e sem consumo de bateria em segundo plano

## 🚀 Instalação

### Pré-requisitos
- Android 11 (API 30) ou superior
- Android Studio (para compilação)

### Baixar APK pronto

📥 **[Download da última versão](https://github.com/weslley75/AudioOutputSwitcher/releases/latest)**

[<img src="https://fdroid.gitlab.io/artwork/badge/get-it-on.png"
     alt="Get it on F-Droid"
     height="80">](https://f-droid.org/packages/br.com.wasystems.audiooutputswitcher/)

### Compilando o APK

1. Clone o repositório:
```bash
git clone https://github.com/weslley75/AudioOutputSwitcher.git
cd AudioOutputSwitcher
```

2. Compile o projeto:
```bash
./gradlew assembleRelease
```

3. O APK será gerado em `app/build/outputs/apk/release/`

### Instalação no dispositivo

1. Instale o APK no seu dispositivo Android
2. Abra as Configurações Rápidas (deslize duas vezes para baixo na barra de status)
3. Toque no ícone de editar (lápis)
4. Encontre "Audio Output" e/ou "Volume Panel" na lista de tiles disponíveis
5. Arraste o(s) tile(s) para a área de tiles ativos

## 🎯 Como usar

**Tile "Audio Output"**
1. Deslize para baixo para abrir as Configurações Rápidas
2. Toque no tile para abrir o seletor de dispositivo de saída de áudio
3. Selecione o dispositivo desejado no diálogo que abrir

**Tile "Volume Panel"**
1. Deslize para baixo para abrir as Configurações Rápidas
2. Toque no tile para abrir o painel de volume do sistema
3. Ajuste volumes de mídia, notificações, alarme e outros

## 🏗️ Arquitetura

O aplicativo é composto por:

- **AudioOutputTileService**: Tile de troca de dispositivo de saída de áudio; comunica-se com o SystemUI via broadcast para abrir o diálogo nativo
- **VolumePanelTileService**: Tile de painel de volume; abre o painel de volume do sistema no toque simples
- **VolumePanelActivity**: Activity transparente acionada pelo long press do tile "Audio Output", abre o painel de volume
- **TileServiceExt**: Extension function compartilhada que encapsula `startActivityAndCollapse` com suporte a Android 14+
- **AudioOutputFallback**: Fallback em cascata — se o broadcast for bloqueado pela ROM, tenta Painel de Volume e depois Configurações de Som
- **Recursos localizados**: Suporte a inglês e português (Brasil)

## 📦 Releases Automáticos

O projeto usa GitHub Actions para:
- ✅ Build automático em cada push/PR
- ✅ Testes automatizados
- ✅ Release automático quando você criar uma tag `v*`
- ✅ APK debug e release disponíveis nos artifacts e releases
- ✅ Dependabot configurado para atualizar dependências automaticamente

**Para criar um release:**
```bash
git tag v1.0.1
git push origin v1.0.1
```

## 🛠️ Desenvolvimento

### Comandos úteis

```bash
# Compilar e instalar versão debug
./gradlew installDebug

# Executar testes unitários
./gradlew test

# Executar testes instrumentados
./gradlew connectedAndroidTest

# Limpar projeto
./gradlew clean
```

### Estrutura do projeto

```
app/src/main/
├── java/br/com/wasystems/audiooutputswitcher/
│   ├── AudioOutputTileService.kt    # Tile de troca de dispositivo de saída
│   ├── VolumePanelTileService.kt    # Tile de painel de volume
│   ├── VolumePanelActivity.kt       # Activity de long press (painel de volume)
│   ├── AudioOutputFallback.kt       # Fallback em cascata
│   └── TileServiceExt.kt            # Extension: startActivityAndCollapse
├── res/
│   ├── values/strings.xml           # Strings em inglês
│   ├── values-pt-rBR/strings.xml    # Strings em português
│   ├── drawable/ic_audio_output.xml # Ícone do tile Audio Output
│   └── drawable/ic_volume_panel.xml # Ícone do tile Volume Panel
└── AndroidManifest.xml
```

## 🤝 Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para:

1. Fazer fork do projeto
2. Criar uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abrir um Pull Request

## 📝 Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

## 🐛 Problemas conhecidos

- Requer Android 11 ou superior (minSdk 30)
- Pode não funcionar em algumas ROMs customizadas que modificam o SystemUI

## 🔧 Solução de problemas

**O tile não aparece nas configurações rápidas:**
- Verifique se você está usando Android 11 ou superior
- Reinicie o dispositivo após a instalação

**O diálogo não abre:**
- Verifique se há dispositivos de áudio conectados
- Tente reproduzir algum áudio antes de usar o tile

## 📞 Suporte

Se você encontrar algum problema ou tiver sugestões, por favor [abra uma issue](https://github.com/weslley75/AudioOutputSwitcher/issues).

---

Desenvolvido com ❤️ por [WA Systems](https://github.com/weslley75)
