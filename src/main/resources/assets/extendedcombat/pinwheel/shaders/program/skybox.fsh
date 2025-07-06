#version 150

in vec3 TexCoords; // Incoming cube map coordinates

out vec4 FragColor; // Final color output

uniform samplerCube skyboxTexture; // Skybox cubemap

void main() {
    FragColor = texture(skyboxTexture, TexCoords);
}